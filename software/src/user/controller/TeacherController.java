package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import user.entity.ParticipateProblemFile;
import user.entity.ParticipateProject;
import user.entity.ParticipateProjectFile;
import user.entity.Project;
import user.entity.Teacher;
import user.entity.Tutor;
import user.service.ParticipateProblemFileService;
import user.service.ParticipateProjectFileService;
import user.service.ParticipateProjectService;
import user.service.ProjectService;
import user.service.TeacherService;
import user.service.TurtorService;
import user.utils.LayuiPager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TurtorService turtorService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ParticipateProjectService participateProjectService;
    @Autowired
    private ParticipateProjectFileService participateProjectFileService;
    @Autowired
    private ParticipateProblemFileService participateProblemFileService;

    /**
     * 项目档案页面
     */
    @RequestMapping("/index")
    public String index() {
        return "Teacher";
    }

    /**
     * 项目档案问题页面
     */
    @RequestMapping("/problem")
    public String problem() {
        return "TeacherParticipateProblem";
    }

    /**
     * 档案详情
     */
    @RequestMapping("/detail")
    public Object detail(String id, HttpServletRequest req) {
        ParticipateProject participateProject = participateProjectService.getById(id);
        if (participateProject != null) {
            Tutor tutor = turtorService.queryById(participateProject.getTutorId());
            if (tutor != null) {
                Teacher teacher = teacherService.queryById(tutor.getTeacherId());
                participateProject.setTeacherName(teacher == null ? "" : teacher.getTeacherName());
            }
            Project project = projectService.queryById(participateProject.getProjectId());
            participateProject.setProjectName(project == null ? "" : project.getProjectName());
            ParticipateProjectFile participateProjectFile = participateProjectFileService.queryById(participateProject.getParticipateProjectId());
            req.setAttribute("participateProjectFile", participateProjectFile);
        }
        req.setAttribute("participateProject", participateProject);
        return "TeacherParticipateProjectDetail";
    }

    /**
     * 项目档案问题页面
     */
    @RequestMapping("/problem/index")
    public String index(String id, HttpServletRequest req) {
        ParticipateProject participateProject = participateProjectService.getById(id);
        if (participateProject != null) {
            Project project = projectService.queryById(participateProject.getProjectId());
            participateProject.setProjectName(project == null ? "" : project.getProjectName());
        }
        req.setAttribute("participateProject", participateProject);
        return "TeacherParticipateProblemList";
    }

    /**
     * 分页获取
     */
    @ResponseBody
    @RequestMapping("/getByPage")
    public Object getByPage(Integer page, Integer limit, String id) {
        LayuiPager<ParticipateProblemFile> result = new LayuiPager<>();
        // 获取列表
        List<ParticipateProblemFile> list = participateProblemFileService.getByPage(page, limit, id);
        // 获取总数量
        Integer totalNum = participateProblemFileService.getTotalNum(id);
        result.setCode(0);
        result.setMsg("");
        result.setData(list);
        result.setCount(totalNum);
        return result;
    }


}
