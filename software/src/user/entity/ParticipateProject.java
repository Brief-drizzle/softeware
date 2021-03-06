package user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (ParticipateProject)实体类
 *参与项目认定表
 * @author makejava
 * @since 2021-01-25 10:10:12
 */
public class ParticipateProject implements Serializable {
    private static final long serialVersionUID = 713366144757100281L;

    private String participateProjectId;

    private String projectId;

    private String tutorId;

    private String mainwork;

    private Object participateStarttime;

    private Object participateEndtime;

    private Integer participateApprovestatus;

    private Date participateApprovetime;

    private String participateApprovetimeStr;

    private Double costequivalent;

    private Integer isdirector;

    private String projectName;

    private String teacherName;

    private String keyDifficulties;

    private String endParticipateWork;

    public String getKeyDifficulties() {
        return keyDifficulties;
    }

    public void setKeyDifficulties(String keyDifficulties) {
        this.keyDifficulties = keyDifficulties;
    }

    public String getEndParticipateWork() {
        return endParticipateWork;
    }

    public void setEndParticipateWork(String endParticipateWork) {
        this.endParticipateWork = endParticipateWork;
    }

    public String getParticipateApprovetimeStr() {
        return participateApprovetimeStr;
    }

    public void setParticipateApprovetimeStr(String participateApprovetimeStr) {
        this.participateApprovetimeStr = participateApprovetimeStr;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getParticipateProjectId() {
        return participateProjectId;
    }

    public void setParticipateProjectId(String participateProjectId) {
        this.participateProjectId = participateProjectId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public String getMainwork() {
        return mainwork;
    }

    public void setMainwork(String mainwork) {
        this.mainwork = mainwork;
    }

    public Object getParticipateStarttime() {
        return participateStarttime;
    }

    public void setParticipateStarttime(Object participateStarttime) {
        this.participateStarttime = participateStarttime;
    }

    public Object getParticipateEndtime() {
        return participateEndtime;
    }

    public void setParticipateEndtime(Object participateEndtime) {
        this.participateEndtime = participateEndtime;
    }

    public Integer getParticipateApprovestatus() {
        return participateApprovestatus;
    }

    public void setParticipateApprovestatus(Integer participateApprovestatus) {
        this.participateApprovestatus = participateApprovestatus;
    }

    public Date getParticipateApprovetime() {
        return participateApprovetime;
    }

    public void setParticipateApprovetime(Date participateApprovetime) {
        this.participateApprovetime = participateApprovetime;
    }

    public Double getCostequivalent() {
        return costequivalent;
    }

    public void setCostequivalent(Double costequivalent) {
        this.costequivalent = costequivalent;
    }

    public Integer getIsdirector() {
        return isdirector;
    }

    public void setIsdirector(Integer isdirector) {
        this.isdirector = isdirector;
    }

}