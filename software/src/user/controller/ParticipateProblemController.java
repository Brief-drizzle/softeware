package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import user.entity.ParticipateProblemFile;
import user.entity.ParticipateProject;
import user.entity.Project;
import user.service.ParticipateProblemFileService;
import user.service.ParticipateProjectService;
import user.service.ProjectService;
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
@RequestMapping("/participateProblem")
public class ParticipateProblemController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private ParticipateProjectService participateProjectService;
    @Autowired
    private ParticipateProblemFileService participateProblemFileService;

    /**
     * 项目档案问题页面
     */
    @RequestMapping("/index")
    public String index(String id, HttpServletRequest req) {
        ParticipateProject participateProject = participateProjectService.getById(id);
        if (participateProject != null) {
            Project project = projectService.queryById(participateProject.getProjectId());
            participateProject.setProjectName(project == null ? "" : project.getProjectName());
        }
        req.setAttribute("participateProject", participateProject);
        return "ParticipateProblemList";
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

    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object add(ParticipateProblemFile participateProblemFile) throws ParseException {
        participateProblemFileService.add(participateProblemFile);
        return new ResultInfo<>(200, "添加成功");
    }

}
