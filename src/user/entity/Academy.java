package user.entity;

import java.io.Serializable;

/**
 * (Academy)实体类
 *
 * @author makejava
 * @since 2021-01-25 10:10:09
 */
public class Academy implements Serializable {
    private static final long serialVersionUID = -34681460027564646L;

    private String academyId;

    private String assistantQualificationId;

    private String academyName;


    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
    }

    public String getAssistantQualificationId() {
        return assistantQualificationId;
    }

    public void setAssistantQualificationId(String assistantQualificationId) {
        this.assistantQualificationId = assistantQualificationId;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

}