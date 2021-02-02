package user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dao.*;
import user.entity.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
public class CourseService {
    @Autowired
    CourseDao courseDao;
    @Autowired
    SelectionDao selectionDao;
    @Autowired
    AssistantAssessmentDao assistantAssessmentDao;
    @Autowired
    AssistantQualificationDao assistantQualificationDao;
    @Autowired
    TeachDao teachDao;
    @Autowired
    PostgraduateDao postgraduateDao;
    /**
     *  获得所有课程
     */
    public List<Course> findall(){
        return courseDao.listAll();
    }
    /**
     * 获得所有学生
     */
    public List<Postgraduate> findallstu(){
        return postgraduateDao.listAll();
    }

    /**
     * 该学生已经有的选择
     */
    public List<Course> findallselection(String id){
        List<Selection> selections=selectionDao.getallByPostId(id);
        List<Course> re=new ArrayList<>();
        for (int i=0;i<selections.size();i++){
            Selection selection=selections.get(i);
            Course course=courseDao.queryById(selection.getCourseId());
            re.add(course);
        }
        return re;
    }

    /**
     * 该学生没有选择的课程
     */
    public List<Course> findmore(String id){
        List<Course> all=courseDao.listAll();
        List<Selection>selections=selectionDao.getallByPostId(id);
        List<Course> re=new ArrayList<>();
        int flag=0;
        for (Course course : all) {
            for (Selection selection : selections) {
                if (selection.getCourseId().equals(course.getCourseId())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                re.add(course);
            }
            flag = 0;
        }
        return re;
    }
    /**
     * 该学生的助教课程
     */
    public List<Course> getAllcourse(String id){
        List<AssistantAssessment> assistantAssessments=assistantAssessmentDao.listAllByPost(id);
        List<Course> courses=new ArrayList<>();
        for (AssistantAssessment as : assistantAssessments) {
            Course course = courseDao.queryById(as.getCourseId());
            courses.add(course);
        }
        return courses;
    }

    /**
     * 寻找已知course和post对应的assistantassessment
     */
    public AssistantAssessment getasas(String courseId,String postId){
        return assistantAssessmentDao.queryByCoursePost(courseId, postId);
    }
    /**
     * 根据id获得course
     */
    public Course getCourse(String courseId){
        return courseDao.queryById(courseId);
    }
    /**
     * 更新assistantassessment
     */
    public void update(AssistantAssessment assistantAssessment){
        assistantAssessmentDao.update(assistantAssessment);
    }

    /**
     * 选择判断以及选择
     */
    public void insert(Selection selection, Postgraduate postgraduate){
        AssistantQualification assistantQualification=assistantQualificationDao.queryByacademyId(postgraduate.getAcademyId());
        List<Selection> selections=selectionDao.listAll();
        Selection selection1=selectionDao.getMax();
        String s1=selection1.getSelectionId();
        String result = s1.substring(s1.length()-9);
        int siz=Integer.parseInt(result)+1;
        String s="z"+ String.format("%09d", siz);
        selection.setSelectionId(s);
        List<Selection> selections1=selectionDao.getallByPostId(postgraduate.getPostgraduateId());
        if (assistantQualification.getAcademyRequire().equals(postgraduate.getPostgraduateSex())){
            if (selections1.size()<2){
                selectionDao.insert(selection);
            }
        }
    }
    /**
     * 授课教师获得自己教授的课程
     */
    public List<Course> getmycourse(String instructorId){
        List<Course> courses=new ArrayList<>();
        Teach teach=  teachDao.queryById(instructorId);
            courses.add(courseDao.queryById(teach.getCourseId()));
        return courses;
    }
    /**
     * 授课教师获得申请助教的学生名单
     */
    public List<Selection> getselect(String instructorId){
        List<Selection> selectionList=new ArrayList<>();
        List<Course>courses=getmycourse(instructorId);
        for (Course cours : courses) {
            List<Selection> selections = selectionDao.getallByCourseId(cours.getCourseId());
            selectionList.addAll(selections);
        }
        return selectionList;
    }
    /**
     * 授课教师获得助教信息
     */
    public List<AssistantAssessment> getallass(String instructorId){
        List<AssistantAssessment> assistantAssessments=new ArrayList<>();
        List<Course>courses=getmycourse(instructorId);
        for (Course course : courses){
            List<AssistantAssessment> assessments=assistantAssessmentDao.listAllByCourse(course.getCourseId());
            assistantAssessments.addAll(assessments);
        }
        return assistantAssessments;
    }
    /**
     * 授课教师选择学生作为助教
     */
    public void selectasass(String courseId,String postId,String instructorid){
        Selection selection=selectionDao.getByPostandCourse(postId, courseId);
        List<AssistantAssessment> assistantAssessments=assistantAssessmentDao.listAll();
        AssistantAssessment assistantAssessment1=assistantAssessmentDao.getMax();
        String s1=assistantAssessment1.getAssessmentId();
        String result = s1.substring(s1.length()-9);
        int siz=Integer.parseInt(result)+1;
        String si="a"+ String.format("%09d", siz);
        AssistantAssessment assistantAssessment=new AssistantAssessment();
        assistantAssessment.setAssessmentId(si);
        assistantAssessment.setCourseId(courseId);
        assistantAssessment.setEvaluateResult(0);
        assistantAssessment.setInstructorId(instructorid);
        assistantAssessment.setPostgraduateId(postId);
        assistantAssessmentDao.insert(assistantAssessment);
        selectionDao.deleteById(selection.getSelectionId());
    }
    /**
     * 申请不通过
     */
    public void notselect(String courseId,String postId)
    {
        Selection selection=selectionDao.getByPostandCourse(postId, courseId);
        selectionDao.deleteById(selection.getSelectionId());
    }
    /**
     * 授课教师获得想要修改的评价表
     */
    public AssistantAssessment getass(String assid){
        return assistantAssessmentDao.queryById(assid);
    }
}