package user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import user.entity.AcademicExchange;
import user.entity.Postgraduate;
import user.service.AcademicExchangeService;
import user.utils.LayuiPager;
import user.utils.ResultInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/academicExchange")
public class AcademicExchangeController {

    @Autowired
    private AcademicExchangeService academicExchangeService;

    @RequestMapping("/index")
    public String index() {
        return "AcademicExchange";
    }

    @RequestMapping("/count")
    public String count() {
        return "AcademicExchangeCount";
    }

    @RequestMapping("/teacher")
    public String teacher() {
        return "AcademicExchangeTeacher";
    }

    @RequestMapping("/student")
    public String student(String id, HttpServletRequest req) {
        req.setAttribute("postgraduateId", id);
        return "AcademicExchangeStudent";
    }

    @RequestMapping("/charge")
    public String charge() {
        return "Director";
    }

    /**
     * 研究生助教信息分析
     * @return
     */
    @RequestMapping("/yjszjxxfx")
    public String yjszjxxfx() {
        return "zj_choose";
    }

    /**
     * 分页获取
     */
    @ResponseBody
    @RequestMapping("/getByPage")
    public Object getByPage(Integer page, Integer limit, String self, HttpSession session) {
        LayuiPager<AcademicExchange> result = new LayuiPager<>();
        Postgraduate postgraduate = (Postgraduate) session.getAttribute("nowpostgraduate");
        if (postgraduate != null && !StringUtils.isEmpty(self)) {
            if ("self".equals(self)) {
                self = postgraduate.getPostgraduateId();
            }
        }
        // 获取列表
        List<AcademicExchange> list = academicExchangeService.getByPage(page, limit, self);
        // 获取总数量
        Integer totalNum = academicExchangeService.getTotalNum();
        result.setCode(0);
        result.setMsg("");
        result.setData(list);
        result.setCount(totalNum);
        return result;
    }

    /**
     * 详情页面
     */
    @RequestMapping("/detail")
    public Object detail(String id, HttpServletRequest req) {
        AcademicExchange academicExchange = academicExchangeService.getById(id);
        req.setAttribute("academicExchange", academicExchange);
        return "AcademicExchangeDetail";
    }

    /**
     * 通过ID获取
     *
     * @param id ID
     */
    @ResponseBody
    @RequestMapping("/getById")
    public Object getById(String id) {
        return new ResultInfo<>(200, academicExchangeService.getById(id) != null);
    }

    /**
     * 审核
     */
    @ResponseBody
    @RequestMapping("/approval")
    public Object approval(String id) {
        academicExchangeService.approval(id);
        return new ResultInfo<>(200, "审核成功");
    }

    /**
     * 负责人审核
     */
    @ResponseBody
    @RequestMapping("/approvalFromDirector")
    public Object approvalFromDirector(String id) {
        academicExchangeService.approvalFromDirector(id);
        return new ResultInfo<>(200, "审核成功");
    }

    /**
     * 添加
     */
    @ResponseBody
    @RequestMapping("/add")
    public Object add(AcademicExchange academicExchange, HttpSession session) throws ParseException {
        Postgraduate postgraduate = (Postgraduate) session.getAttribute("nowpostgraduate");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        academicExchange.setTutorAuditTime(format.parse(academicExchange.getTutorAuditTimeStr()));
        academicExchange.setDirectorAuditTime(format.parse(academicExchange.getDirectorAuditTimeStr()));
        academicExchange.setPostgraduateId(postgraduate == null ? null : postgraduate.getPostgraduateId());
        academicExchangeService.add(academicExchange);
        return new ResultInfo<>(200, "添加成功");
    }

}
