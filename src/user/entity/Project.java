package user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Project)实体类
 *项目
 * @author makejava
 * @since 2021-01-25 10:10:13
 */
public class Project implements Serializable {
    private static final long serialVersionUID = 241965270638859191L;

    private String projectId;

    private String categoryId;

    private String tutorId;

    private String projectName;

    private Object starttime;

    private Object endtime;

    private Double allfunds;

    private Integer approveStatus;

    private Date approveTime;


    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Object getStarttime() {
        return starttime;
    }

    public void setStarttime(Object starttime) {
        this.starttime = starttime;
    }

    public Object getEndtime() {
        return endtime;
    }

    public void setEndtime(Object endtime) {
        this.endtime = endtime;
    }

    public Double getAllfunds() {
        return allfunds;
    }

    public void setAllfunds(Double allfunds) {
        this.allfunds = allfunds;
    }

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

}