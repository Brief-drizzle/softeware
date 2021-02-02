package user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Selection)实体类
 *志愿选择
 * @author makejava
 * @since 2021-01-25 10:10:08
 */
public class Selection implements Serializable {
    private static final long serialVersionUID = 752383553679462121L;

    private String selectionId;

    private String postgraduateId;

    private String courseId;

    private Date selectionTime;


    public String getSelectionId() {
        return selectionId;
    }

    public void setSelectionId(String selectionId) {
        this.selectionId = selectionId;
    }

    public String getPostgraduateId() {
        return postgraduateId;
    }

    public void setPostgraduateId(String postgraduateId) {
        this.postgraduateId = postgraduateId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Date getSelectionTime() {
        return selectionTime;
    }

    public void setSelectionTime(Date selectionTime) {
        this.selectionTime = selectionTime;
    }

}