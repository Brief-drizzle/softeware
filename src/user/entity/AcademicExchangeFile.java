package user.entity;

import java.io.Serializable;

/**
 * (AcademicExchangeFile)实体类
 *学术交流情况档案
 * @author makejava
 * @since 2021-01-25 10:10:11
 */
public class AcademicExchangeFile implements Serializable {
    private static final long serialVersionUID = -28756113575531390L;

    private String academicExchangeFileId;

    private String teacherId;

    private String aeApplyStatus;

    private String aeJoinStatus;

    private String aeFinishStatus;


    public String getAcademicExchangeFileId() {
        return academicExchangeFileId;
    }

    public void setAcademicExchangeFileId(String academicExchangeFileId) {
        this.academicExchangeFileId = academicExchangeFileId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getAeApplyStatus() {
        return aeApplyStatus;
    }

    public void setAeApplyStatus(String aeApplyStatus) {
        this.aeApplyStatus = aeApplyStatus;
    }

    public String getAeJoinStatus() {
        return aeJoinStatus;
    }

    public void setAeJoinStatus(String aeJoinStatus) {
        this.aeJoinStatus = aeJoinStatus;
    }

    public String getAeFinishStatus() {
        return aeFinishStatus;
    }

    public void setAeFinishStatus(String aeFinishStatus) {
        this.aeFinishStatus = aeFinishStatus;
    }

}