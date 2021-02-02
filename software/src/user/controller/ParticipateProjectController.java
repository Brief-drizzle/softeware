package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import user.entity.ParticipateProject;
import user.entity.ParticipateProjectFile;
import user.entity.Project;
import user.entity.Teacher;
import user.entity.Tutor;
import user.service.ParticipateProjectFileService;
import user.service.ParticipateProjectService;
import user.service.ProjectService;
import user.service.TeacherService;
import user.service.TurtorService;
import user.utils.LayuiPager;
import user.utils.ResultInfo;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 项目档案控制器
 */
@Controller
@RequestMapping("/participateProject")
public class ParticipateProjectController {

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

    /**
     * 项目档案页面
     */
    @RequestMapping("/index")
    public String index() {
        return "ParticipateProject";
    }

    /**
     * 项目档案问题页面
     */
    @RequestMapping("/problem")
    public String problem() {
        return "ParticipateProblem";
    }

    /**
     * 分页获取
     */
    @ResponseBody
    @RequestMapping("/getByPage")
    public Object getByPage(Integer page, Integer limit) {
        LayuiPager<ParticipateProject> result = new LayuiPager<>();
        // 获取列表
        List<ParticipateProject> list = participateProjectService.getByPage(page, limit);
        for (ParticipateProject item : list) {
            Project project = projectService.queryById(item.getProjectId());
            item.setProjectName(project == null ? "" : project.getProjectName());
            Tutor tutor = turtorService.queryById(item.getTutorId());
            if (tutor != null) {
                Teacher teacher = teacherService.queryById(tutor.getTeacherId());
                item.setTeacherName(teacher == null ? "" : teacher.getTeacherName());
            }
            ParticipateProjectFile participateProjectFile = participateProjectFileService.queryById(item.getParticipateProjectId());
            item.setKeyDifficulties(participateProjectFile == null ? "" : participateProjectFile.getKeyDifficulties());
            item.setEndParticipateWork(participateProjectFile == null ? "" : participateProjectFile.getEndParticipateWork());
        }
        // 获取总数量
        Integer totalNum = participateProjectService.getTotalNum();
        result.setCode(0);
        result.setMsg("");
        result.setData(list);
        result.setCount(totalNum);
        return result;
    }

    /**
     * 通过ID获取
     *
     * @param id ID
     */
    @ResponseBody
    @RequestMapping("/getById")
    public Object getById(String id) {
        return new ResultInfo<>(200, participateProjectService.getById(id) != null);
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
        return "ParticipateProjectDetail";
    }

    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object add(ParticipateProject participateProject) throws ParseException {
        if (!StringUtils.isEmpty(participateProject.getParticipateApprovetimeStr())) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            participateProject.setParticipateApprovetime(format.parse(participateProject.getParticipateApprovetimeStr()));
        }
        ParticipateProjectFile participateProjectFile = new ParticipateProjectFile();
        participateProjectFile.setParticipateProjectFileId(participateProject.getParticipateProjectId());
        Tutor tutor = turtorService.queryById(participateProject.getTutorId());
        if (tutor != null) {
            participateProjectFile.setTeacherId(tutor.getTeacherId());
        }
        participateProjectFile.setKeyDifficulties(participateProject.getKeyDifficulties());
        participateProjectFile.setEndParticipateWork(participateProject.getEndParticipateWork());
        participateProjectFileService.add(participateProjectFile);
        participateProjectService.add(participateProject);
        return new ResultInfo<>(200, "添加成功");
    }

}
