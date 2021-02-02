package user.entity;

import java.io.Serializable;

/**
 * (Teacher)实体类
 *教师
 * @author makejava
 * @since 2021-01-25 10:10:10
 */
public class Teacher implements Serializable {
    private static final long serialVersionUID = -93332899048543362L;

    private String teacherId;

    private String teacherName;

    private String teacherStatus;

    private String teacherPhone;

    private Object teacherBirth;

    private String teacherEmail;

    private String teacherSex;


    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(String teacherStatus) {
        this.teacherStatus = teacherStatus;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public Object getTeacherBirth() {
        return teacherBirth;
    }

    public void setTeacherBirth(Object teacherBirth) {
        this.teacherBirth = teacherBirth;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

}