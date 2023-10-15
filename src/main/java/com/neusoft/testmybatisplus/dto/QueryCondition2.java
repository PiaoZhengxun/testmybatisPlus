package com.neusoft.testmybatisplus.dto;

import java.io.Serializable;

public class QueryCondition2 implements Serializable {

    private Integer deptno;
    private String ename;

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "QueryCondition2{" +
                "deptno=" + deptno +
                ", ename='" + ename + '\'' +
                '}';
    }
}
