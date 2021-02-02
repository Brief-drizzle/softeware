package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import user.entity.Postgraduate;
import user.entity.Teacher;
import user.service.PostgraduateService;
import user.utils.LayuiPager;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private PostgraduateService postgraduateService;

    @RequestMapping("/index")
    public String student() {
        return "Student";
    }

    /**
     * 分页获取
     */
    @ResponseBody
    @RequestMapping("/getByPage")
    public Object getByPage(Integer page, Integer limit, HttpSession session) {
        LayuiPager<Postgraduate> result = new LayuiPager<>();
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        // 获取列表
        List<Postgraduate> list = postgraduateService.getByPage(page, limit, teacher == null ? null : teacher.getTeacherId());
        // 获取总数量
        Integer totalNum = postgraduateService.getTotalNum(teacher == null ? null : teacher.getTeacherId());
        result.setCode(0);
        result.setMsg("");
        result.setData(list);
        result.setCount(totalNum);
        return result;
    }

}
