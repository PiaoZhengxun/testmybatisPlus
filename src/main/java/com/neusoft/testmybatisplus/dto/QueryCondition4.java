package com.neusoft.testmybatisplus.dto;

import java.io.Serializable;

public class QueryCondition4 implements Serializable {

    private String username;
    private Integer userid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "QueryCondition4{" +
                "username='" + username + '\'' +
                ", userid=" + userid +
                '}';
    }
}
