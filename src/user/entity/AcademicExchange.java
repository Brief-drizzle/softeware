package user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (AcademicExchange)实体类
 *学术交流活动表
 * @author makejava
 * @since 2021-01-25 10:10:10
 */
public class AcademicExchange implements Serializable {
    private static final long serialVersionUID = -18292189454777806L;

    private String academicExchangeId;

    private String postgraduateId;

    private String tutorId;

    private String directorId;

    private String academicExchangeName;

    private String reportEnglishname;

    private String reportChinesename;

    private String country;

    private String province;

    private String city;

    private Integer quality;

    private String activityPhoto;

    private String others;

    private Integer auditStatus;

    private Date tutorAuditTime;

    private Date directorAuditTime;


    public String getAcademicExchangeId() {
        return academicExchangeId;
    }

    public void setAcademicExchangeId(String academicExchangeId) {
        this.academicExchangeId = academicExchangeId;
    }

    public String getPostgraduateId() {
        return postgraduateId;
    }

    public void setPostgraduateId(String postgraduateId) {
        this.postgraduateId = postgraduateId;
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public String getDirectorId() {
        return directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    public String getAcademicExchangeName() {
        return academicExchangeName;
    }

    public void setAcademicExchangeName(String academicExchangeName) {
        this.academicExchangeName = academicExchangeName;
    }

    public String getReportEnglishname() {
        return reportEnglishname;
    }

    public void setReportEnglishname(String reportEnglishname) {
        this.reportEnglishname = reportEnglishname;
    }

    public String getReportChinesename() {
        return reportChinesename;
    }

    public void setReportChinesename(String reportChinesename) {
        this.reportChinesename = reportChinesename;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public String getActivityPhoto() {
        return activityPhoto;
    }

    public void setActivityPhoto(String activityPhoto) {
        this.activityPhoto = activityPhoto;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Date getTutorAuditTime() {
        return tutorAuditTime;
    }

    public void setTutorAuditTime(Date tutorAuditTime) {
        this.tutorAuditTime = tutorAuditTime;
    }

    public Date getDirectorAuditTime() {
        return directorAuditTime;
    }

    public void setDirectorAuditTime(Date directorAuditTime) {
        this.directorAuditTime = directorAuditTime;
    }

}