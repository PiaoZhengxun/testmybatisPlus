package com.neusoft.testmybatisplus.dto;

import com.neusoft.testmybatisplus.entity.Dept;

import java.io.Serializable;

public class DeptInfo2 implements Serializable {

    private int empcountnum;
    private Dept dept;

    public int getEmpcountnum() {
        return empcountnum;
    }

    public void setEmpcountnum(int empcountnum) {
        this.empcountnum = empcountnum;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "DeptInfo2{" +
                "empcountnum=" + empcountnum +
                ", dept=" + dept +
                '}';
    }
}
