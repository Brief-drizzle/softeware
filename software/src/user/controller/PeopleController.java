package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import user.entity.*;
import user.service.DirectorService;
import user.service.InstructorService;
import user.service.PeopleService;
import user.service.PostgraduateService;
import user.service.TeacherService;
import user.service.TurtorService;
import user.service.CourseService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author ad
 */
@Controller
@RequestMapping(path = "/user")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;
    @Autowired
    private TurtorService turtorService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private DirectorService directorService;
    @Autowired
    private InstructorService instructorService;
    @Autowired
    private PostgraduateService postgraduateService;
    @Autowired
    private CourseService courseService;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session) {
        People people = peopleService.login(username, password);
        if (people == null) {
            return "index";
        } else {
            if ("u000000001".equals(people.getPeoplecategoryId())) {
                Postgraduate postgraduate = postgraduateService.getPo(username);
                getPostinfor(people.getPeopleId(),session);
                session.setAttribute("nowpostgraduate", postgraduate);
                return "Postgraduate";
            } else if ("u000000003".equals(people.getPeoplecategoryId())) {
                Director director = directorService.queryById(username);
                if (director != null) {
                    Teacher teacher = teacherService.queryById(director.getTeacherId());
                    session.setAttribute("teacher", teacher);
                }
                getPostinfor(people.getPeopleId(),session);
                return "Director";
            } else {
                getTeacherStatus(username, session);
                return "Teacheridentity";
            }
        }
    }

    /**获得teacher的身份**/
    public void getTeacherStatus(String id, HttpSession session) {
        Tutor tutor = turtorService.getStatus(id);
        Instructor instructor = instructorService.getStatus(id);
        if (tutor != null) {
            Teacher teacher = teacherService.queryById(tutor.getTeacherId());
            session.setAttribute("teacher", teacher);
        }
        session.setAttribute("istutor", tutor);
        session.setAttribute("isinstructor", instructor);
    }

    /**获得学生的助教的相关信息**/
    public void getPostinfor(String id,HttpSession session){
        List<Course> courses=courseService.findall();
        session.setAttribute("allcourses", courses);
        List<Course> selections=courseService.findallselection(id);
        session.setAttribute("myselection", selections);
        List<Course> othercourse=courseService.findmore(id);
        session.setAttribute("morecourse", othercourse);
        List<Course> alreadycourse=courseService.getAllcourse(id);
        session.setAttribute("asas", alreadycourse);
    }

}
