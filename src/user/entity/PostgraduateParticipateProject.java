package user.entity;

import java.io.Serializable;

/**
 * (PostgraduateParticipateProject)实体类
 *
 * @author makejava
 * @since 2021-01-25 10:10:12
 */
public class PostgraduateParticipateProject implements Serializable {
    private static final long serialVersionUID = 862869156598360888L;

    private String postgraduateId;

    private String participateProjectId;


    public String getPostgraduateId() {
        return postgraduateId;
    }

    public void setPostgraduateId(String postgraduateId) {
        this.postgraduateId = postgraduateId;
    }

    public String getParticipateProjectId() {
        return participateProjectId;
    }

    public void setParticipateProjectId(String participateProjectId) {
        this.participateProjectId = participateProjectId;
    }

}