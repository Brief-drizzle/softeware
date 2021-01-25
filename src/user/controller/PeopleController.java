package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import user.entity.Instructor;
import user.entity.People;
import user.entity.Postgraduate;
import user.entity.Tutor;
import user.service.InstructorService;
import user.service.PeopleService;
import user.service.PostgraduateService;
import user.service.TurtorService;

import javax.servlet.http.HttpSession;


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
                return "Postgraduate";
            }
            else {
                getTeacherStatus(username, session);
                return "Teacher";
            }
        }
    }

    public void getTeacherStatus(String id,HttpSession session){
        Tutor tutor=turtorService.getStatus(id);
        Instructor instructor=instructorService.getStatus(id);
        session.setAttribute("istutor", tutor);
        session.setAttribute("isinstructor", instructor);
    }
}
