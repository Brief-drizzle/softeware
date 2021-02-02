package user.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import user.entity.Teacher;
import user.entity.Tutor;
import user.service.TeacherService;
import user.service.TurtorService;
import user.utils.ResultInfo;

import java.util.List;

/**
 * 导师控制器
 */
@Controller
@RequestMapping("/tutor")
public class TutorController {

    @Autowired
    private TurtorService turtorService;
    @Autowired
    private TeacherService teacherService;

    /**
     * 查询全部
     */
    @ResponseBody
    @RequestMapping("/queryAll")
    public Object queryAll() {
        List<Tutor> list = turtorService.queryAll();
        JSONArray result = new JSONArray();
        for (Tutor item : list) {
            JSONObject obj = new JSONObject();
            obj.put("id", item.getTutorId());
            Teacher teacher = teacherService.queryById(item.getTeacherId());
            obj.put("name", teacher == null ? "-" : teacher.getTeacherName());
            result.add(obj);
        }
        return new ResultInfo<>(200, result);
    }

}
