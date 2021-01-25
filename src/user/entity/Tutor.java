package user.entity;

import java.io.Serializable;

/**
 * (Tutor)实体类
 *
 * @author makejava
 * @since 2021-01-25 10:10:14
 */
public class Tutor implements Serializable {
    private static final long serialVersionUID = -48340701081951468L;

    private String tutorId;

    private String teacherId;

    private Integer istutor;


    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getIstutor() {
        return istutor;
    }

    public void setIstutor(Integer istutor) {
        this.istutor = istutor;
    }

}