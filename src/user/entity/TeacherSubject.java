package user.entity;

import java.io.Serializable;

/**
 * (TeacherSubject)实体类
 *
 * @author makejava
 * @since 2021-01-25 10:10:13
 */
public class TeacherSubject implements Serializable {
    private static final long serialVersionUID = -68492772671360257L;

    private String subjectId;

    private String teacherId;


    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

}