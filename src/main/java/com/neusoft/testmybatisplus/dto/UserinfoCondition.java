package com.neusoft.testmybatisplus.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class UserinfoCondition implements Serializable {

   private int userid;
   private String username;
   private int status;
   private Date hiredateStart;
   private Date hiredateEnd;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getHiredateStart() {
        return hiredateStart;
    }

    public void setHiredateStart(Date hiredateStart) {
        this.hiredateStart = hiredateStart;
    }

    public Date getHiredateEnd() {
        return hiredateEnd;
    }

    public void setHiredateEnd(Date hiredateEnd) {
        this.hiredateEnd = hiredateEnd;
    }

    @Override
    public String toString() {
        return "UserinfoCondition{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", status=" + status +
                ", hiredateStart=" + hiredateStart +
                ", hiredateEnd=" + hiredateEnd +
                '}';
    }
}
