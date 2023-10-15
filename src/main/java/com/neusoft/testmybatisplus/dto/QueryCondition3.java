package com.neusoft.testmybatisplus.dto;

import java.io.Serializable;

public class QueryCondition3 implements Serializable {

    private String ename;
    private Integer empno;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    @Override
    public String toString() {
        return "QueryCondition3{" +
                "ename='" + ename + '\'' +
                ", empno=" + empno +
                '}';
    }
}
