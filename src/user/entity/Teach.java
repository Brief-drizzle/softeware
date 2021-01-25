package user.entity;

import java.io.Serializable;

/**
 * (Teach)实体类
 *
 * @author makejava
 * @since 2021-01-25 10:10:09
 */
public class Teach implements Serializable {
    private static final long serialVersionUID = -56978744226288423L;

    private String instructorId;

    private String courseId;


    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

}