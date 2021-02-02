package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import user.entity.*;
import user.service.CourseService;
import user.service.PostgraduateService;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    /**
     * 进入自评页面
     */
    @RequestMapping("/selfaccount")
    public String selfaccount(String courseid, HttpSession session){
        Postgraduate postgraduate= (Postgraduate) session.getAttribute("nowpostgraduate");
        getPostinfor(postgraduate.getPostgraduateId(), session,courseid);
        return "zj_selfaccount";
    }

    /**
     * 添加自评
     */
    @RequestMapping("/setselfaccount")
    public String setselfaccount(String self,HttpSession session) throws UnsupportedEncodingException {
        Postgraduate postgraduate= (Postgraduate) session.getAttribute("nowpostgraduate");
        Course course= (Course) session.getAttribute("nowcourse");
        AssistantAssessment assistantAssessment =courseService.getasas(course.getCourseId(), postgraduate.getPostgraduateId());
        self=new String(self.getBytes("ISO-8859-1"),"utf-8");
        assistantAssessment.setSelfAccount(self);
        courseService.update(assistantAssessment);
        getPostinfor(postgraduate.getPostgraduateId(), session, course.getCourseId());
        return "zj_choose";
    }

    /**
     * 选志愿
     */
    @RequestMapping("/choose")
    public String choose(String courseId,HttpSession session) throws ParseException {
        Postgraduate postgraduate= (Postgraduate) session.getAttribute("nowpostgraduate");
        Selection selection=new Selection();
        selection.setCourseId(courseId);
        selection.setPostgraduateId(postgraduate.getPostgraduateId());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置日期格式
        String date=df.format(new Date());
        // new Date()为获取当前系统时间
        selection.setSelectionTime(df.parse(date));
        courseService.insert(selection, postgraduate);
        getPostinfor(postgraduate.getPostgraduateId(), session, courseId);
        return "zj_choose";
    }

    /**获得学生的助教的相关信息**/
    public void getPostinfor(String id,HttpSession session,String courseId){
        List<Course> courses=courseService.findall();
        session.setAttribute("allcourses", courses);
        List<Course> selections=courseService.findallselection(id);
        session.setAttribute("myselection", selections);
        List<Course> othercourse=courseService.findmore(id);
        session.setAttribute("morecourse", othercourse);
        List<Course> alreadycourse=courseService.getAllcourse(id);
        session.setAttribute("asas", alreadycourse);
        AssistantAssessment assistantAssessment =courseService.getasas(courseId, id);
        session.setAttribute("assis", assistantAssessment);
        Course course=courseService.getCourse(courseId);
        session.setAttribute("nowcourse", course);
    }
    /**
     * 进入导师的操作页
     */
    @RequestMapping("/enterinstru")
    public String ent(HttpSession session){
        getinsinfo(session);
        return "zj_instructor";
    }

    /**
     * 申请通过
     */
    @RequestMapping("/select")
    public String select(String postid,String courseId,HttpSession session){
        Instructor instructor= (Instructor) session.getAttribute("isinstructor");
        courseService.selectasass(courseId, postid, instructor.getInstructorId());
        getinsinfo(session);
        return "zj_instructor";
    }

    /**
     * 申请不通过
     */
    @RequestMapping("/notselect")
    public String notselect(String postid,String courseId,HttpSession session){
        courseService.notselect(courseId, postid);
        getinsinfo(session);
        return "zj_instructor";
    }

    /**
     * 进入授课教师修改评价表
     */
    @RequestMapping("/enterevaluate")
    public String enterevaluate(String assid,HttpSession session){
        AssistantAssessment assessment=courseService.getass(assid);
        session.setAttribute("nowass", assessment);
        Course course=courseService.getCourse(assessment.getCourseId());
        session.setAttribute("evacourse", course);
        getinsinfo(session);
        return "zj_instructorevaluate";
    }

    /**
     * 添加评价
     */
    @RequestMapping("/evaluate")
    public String evaluate(String evaluate,int result,HttpSession session) throws UnsupportedEncodingException {
        AssistantAssessment assistant= (AssistantAssessment) session.getAttribute("nowass");
        evaluate=new String(evaluate.getBytes("ISO-8859-1"),"utf-8");
        assistant.setInstructorEvaluate(evaluate);
        assistant.setEvaluateResult(result);
        courseService.update(assistant);
        getinsinfo(session);
        return "zj_instructor";
    }

    /**
     * 获得授课教师可知的信息，包括授课课程已选择成为助教的学生信息
     */
    public void getinsinfo(HttpSession session){
        Instructor instructor= (Instructor) session.getAttribute("isinstructor");
        session.setAttribute("isinstructor", instructor);
        List<Course> mycourse=courseService.getmycourse(instructor.getInstructorId());
        session.setAttribute("mycourses", mycourse);
        List<Selection> selections=courseService.getselect(instructor.getInstructorId());
        session.setAttribute("allselections", selections);
        List<AssistantAssessment> assistantAssessments=courseService.getallass(instructor.getInstructorId());
        session.setAttribute("allassis", assistantAssessments);
        List<Postgraduate> postgraduates=courseService.findallstu();
        session.setAttribute("allpost", postgraduates);
    }
}
