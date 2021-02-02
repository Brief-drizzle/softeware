package user.entity;

import java.io.Serializable;

/**
 * (Subject)实体类
 *学科
 * @author makejava
 * @since 2021-01-25 10:10:13
 */
public class Subject implements Serializable {
    private static final long serialVersionUID = 418526977682116588L;

    private String subjectId;

    private String directorId;

    private String subjectName;

    private String subjectCategoryname;

    private String subjectIntroduction;


    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getDirectorId() {
        return directorId;
    }

    public void setDirectorId(String directorId) {
        this.directorId = directorId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCategoryname() {
        return subjectCategoryname;
    }

    public void setSubjectCategoryname(String subjectCategoryname) {
        this.subjectCategoryname = subjectCategoryname;
    }

    public String getSubjectIntroduction() {
        return subjectIntroduction;
    }

    public void setSubjectIntroduction(String subjectIntroduction) {
        this.subjectIntroduction = subjectIntroduction;
    }

}