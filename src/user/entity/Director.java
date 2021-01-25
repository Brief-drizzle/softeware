package user.entity;

import java.io.Serializable;

/**
 * (Director)实体类
 *
 * @author makejava
 * @since 2021-01-25 10:10:11
 */
public class Director implements Serializable {
    private static final long serialVersionUID = -53079775797955069L;

    private String directorId;

    private String teacherId;

    private String subjectId;

    private Integer isDirector;


    public String getDirectorId() {
        return directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getIsDirector() {
        return isDirector;
    }

    public void setIsDirector(Integer isDirector) {
        this.isDirector = isDirector;
    }

}