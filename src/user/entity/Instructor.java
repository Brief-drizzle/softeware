package user.entity;

import java.io.Serializable;

/**
 * (Instructor)实体类
 *授课教师
 * @author makejava
 * @since 2021-01-25 10:10:09
 */
public class Instructor implements Serializable {
    private static final long serialVersionUID = -12557966264546471L;

    private String instructorId;

    private String teacherId;

    private Integer isinstructor;


    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getIsinstructor() {
        return isinstructor;
    }

    public void setIsinstructor(Integer isinstructor) {
        this.isinstructor = isinstructor;
    }

}