package user.entity;

import java.io.Serializable;

/**
 * (AssistantQualification)实体类
 *助教资格
 * @author makejava
 * @since 2021-01-25 10:10:10
 */
public class AssistantQualification implements Serializable {
    private static final long serialVersionUID = -78901789371399080L;

    private String assistantQualificationId;

    private String academyId;

    private String academyRequire;


    public String getAssistantQualificationId() {
        return assistantQualificationId;
    }

    public void setAssistantQualificationId(String assistantQualificationId) {
        this.assistantQualificationId = assistantQualificationId;
    }

    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
    }

    public String getAcademyRequire() {
        return academyRequire;
    }

    public void setAcademyRequire(String academyRequire) {
        this.academyRequire = academyRequire;
    }

}