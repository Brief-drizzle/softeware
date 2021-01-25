package user.entity;

import java.io.Serializable;

/**
 * (Peoplecategory)实体类
 *
 * @author makejava
 * @since 2021-01-25 10:10:04
 */
public class Peoplecategory implements Serializable {
    private static final long serialVersionUID = 203556176587013491L;

    private String peoplecategoryId;

    private String peoplecategoryName;

    private Integer nowId;


    public String getPeoplecategoryId() {
        return peoplecategoryId;
    }

    public void setPeoplecategoryId(String peoplecategoryId) {
        this.peoplecategoryId = peoplecategoryId;
    }

    public String getPeoplecategoryName() {
        return peoplecategoryName;
    }

    public void setPeoplecategoryName(String peoplecategoryName) {
        this.peoplecategoryName = peoplecategoryName;
    }

    public Integer getNowId() {
        return nowId;
    }

    public void setNowId(Integer nowId) {
        this.nowId = nowId;
    }

}