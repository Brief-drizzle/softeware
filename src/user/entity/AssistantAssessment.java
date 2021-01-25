package user.entity;

import java.io.Serializable;

/**
 * (AssistantAssessment)实体类
 *研究生助教评定
 * @author makejava
 * @since 2021-01-25 10:10:08
 */
public class AssistantAssessment implements Serializable {
    private static final long serialVersionUID = -35905494295918118L;

    private String assessmentId;

    private String postgraduateId;

    private String courseId;

    private String instructorId;

    private String selfAccount;

    private String instructorEvaluate;

    private Integer evaluateResult;


    public String getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getPostgraduateId() {
        return postgraduateId;
    }

    public void setPostgraduateId(String postgraduateId) {
        this.postgraduateId = postgraduateId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getSelfAccount() {
        return selfAccount;
    }

    public void setSelfAccount(String selfAccount) {
        this.selfAccount = selfAccount;
    }

    public String getInstructorEvaluate() {
        return instructorEvaluate;
    }

    public void setInstructorEvaluate(String instructorEvaluate) {
        this.instructorEvaluate = instructorEvaluate;
    }

    public Integer getEvaluateResult() {
        return evaluateResult;
    }

    public void setEvaluateResult(Integer evaluateResult) {
        this.evaluateResult = evaluateResult;
    }

}