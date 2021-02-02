package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import user.entity.*;
import user.service.*;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author ad
 */
@Controller
@RequestMapping(path = "/user")
public class PeopleController {
    @Autowired
    PeopleService peopleService;
    @Autowired
    TurtorService turtorService;
    @Autowired
    InstructorService instructorService;
    @Autowired
    PostgraduateService postgraduateService;
    @Autowired
    CourseService courseService;

    /**登录**/
    @RequestMapping(path = "/login",method = RequestMethod.POST)
    public String login(String username, String password, HttpSession session)
    {
        People people=peopleService.login(username, password);
        if (people==null){
            return "index";
        }
        else {
            if ("u000000001".equals(people.getPeoplecategoryId())){
                Postgraduate postgraduate=postgraduateService.getPo(username);
                session.setAttribute("nowpostgraduate", postgraduate);
                getPostinfor(username, session);
                return "Postgraduate";
            }
            else {
                getTeacherStatus(username, session);
                return "Teacher";
            }
        }
    }
    /**获得teacher的身份**/
    public void getTeacherStatus(String id,HttpSession session){
        Tutor tutor=turtorService.getStatus(id);
        Instructor instructor=instructorService.getStatus(id);
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
