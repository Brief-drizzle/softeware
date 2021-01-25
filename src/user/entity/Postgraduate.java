package user.entity;

import java.io.Serializable;

/**
 * (Postgraduate)实体类
 *
 * @author makejava
 * @since 2021-01-25 10:10:08
 */
public class Postgraduate implements Serializable {
    private static final long serialVersionUID = -66655246350200084L;

    private String postgraduateId;

    private String teacherId;

    private String academyId;

    private String postgraduateName;

    private String postgraduatePhone;

    private String postgraduateEmail;

    private Object postgraduateBirth;

    private String postgraduateSex;


    public String getPostgraduateId() {
        return postgraduateId;
    }

    public void setPostgraduateId(String postgraduateId) {
        this.postgraduateId = postgraduateId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
    }

    public String getPostgraduateName() {
        return postgraduateName;
    }

    public void setPostgraduateName(String postgraduateName) {
        this.postgraduateName = postgraduateName;
    }

    public String getPostgraduatePhone() {
        return postgraduatePhone;
    }

    public void setPostgraduatePhone(String postgraduatePhone) {
        this.postgraduatePhone = postgraduatePhone;
    }

    public String getPostgraduateEmail() {
        return postgraduateEmail;
    }

    public void setPostgraduateEmail(String postgraduateEmail) {
        this.postgraduateEmail = postgraduateEmail;
    }

    public Object getPostgraduateBirth() {
        return postgraduateBirth;
    }

    public void setPostgraduateBirth(Object postgraduateBirth) {
        this.postgraduateBirth = postgraduateBirth;
    }

    public String getPostgraduateSex() {
        return postgraduateSex;
    }

    public void setPostgraduateSex(String postgraduateSex) {
        this.postgraduateSex = postgraduateSex;
    }

}