package user.entity;

import java.io.Serializable;

/**
 * (ParticipateProjectFile)实体类
 *研究生参与项目档案
 * @author makejava
 * @since 2021-01-25 10:10:12
 */
public class ParticipateProjectFile implements Serializable {
    private static final long serialVersionUID = 943644887262474066L;

    private String participateProjectFileId;

    private String teacherId;

    private String firstParticipateProject;

    private String keyDifficulties;

    private String endParticipateWork;


    public String getParticipateProjectFileId() {
        return participateProjectFileId;
    }

    public void setParticipateProjectFileId(String participateProjectFileId) {
        this.participateProjectFileId = participateProjectFileId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstParticipateProject() {
        return firstParticipateProject;
    }

    public void setFirstParticipateProject(String firstParticipateProject) {
        this.firstParticipateProject = firstParticipateProject;
    }

    public String getKeyDifficulties() {
        return keyDifficulties;
    }

    public void setKeyDifficulties(String keyDifficulties) {
        this.keyDifficulties = keyDifficulties;
    }

    public String getEndParticipateWork() {
        return endParticipateWork;
    }

    public void setEndParticipateWork(String endParticipateWork) {
        this.endParticipateWork = endParticipateWork;
    }

}