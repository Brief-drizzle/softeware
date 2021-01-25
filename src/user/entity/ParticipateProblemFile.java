package user.entity;

import java.io.Serializable;

/**
 * (ParticipateProblemFile)实体类
 *研究生参与项目问题档案
 * @author makejava
 * @since 2021-01-25 10:10:11
 */
public class ParticipateProblemFile implements Serializable {
    private static final long serialVersionUID = 726835264226557541L;

    private String problemFileid;

    private String teacherId;

    private String problemDescription;

    private String solveProcess;


    public String getProblemFileid() {
        return problemFileid;
    }

    public void setProblemFileid(String problemFileid) {
        this.problemFileid = problemFileid;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getSolveProcess() {
        return solveProcess;
    }

    public void setSolveProcess(String solveProcess) {
        this.solveProcess = solveProcess;
    }

}