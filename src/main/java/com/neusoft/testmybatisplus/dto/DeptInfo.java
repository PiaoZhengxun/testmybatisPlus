package com.neusoft.testmybatisplus.dto;

import java.io.Serializable;

public class DeptInfo implements Serializable {

    private int deptno;
    private String deptname;
    private String deptloc;


    private int empcountnum;



    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptloc() {
        return deptloc;
    }

    public void setDeptloc(String deptloc) {
        this.deptloc = deptloc;
    }

    public int getEmpcountnum() {
        return empcountnum;
    }

    public void setEmpcountnum(int empcountnum) {
        this.empcountnum = empcountnum;
    }

    @Override
    public String toString() {
        return "DeptInfo{" +
                "deptno=" + deptno +
                ", deptname=" + deptname +
                ", deptloc=" + deptloc +
                ", empcountnum=" + empcountnum +
                '}';
    }
}
