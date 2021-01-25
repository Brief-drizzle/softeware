package user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (People)实体类
 *用户
 * @author makejava
 * @since 2021-01-25 10:10:04
 */
public class People implements Serializable {
    private static final long serialVersionUID = -90009113750581254L;

    private String peopleId;

    private String peoplecategoryId;

    private String password;

    private Date lastlogintime;

    private String lastloginip;


    public String getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(String peopleId) {
        this.peopleId = peopleId;
    }

    public String getPeoplecategoryId() {
        return peoplecategoryId;
    }

    public void setPeoplecategoryId(String peoplecategoryId) {
        this.peoplecategoryId = peoplecategoryId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip;
    }

}