package com.neusoft.testmybatisplus.dto;

import java.io.Serializable;

public class Userid implements Serializable {

    private int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "Userid{" +
                "userid=" + userid +
                '}';
    }
}
