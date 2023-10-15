package com.neusoft.testmybatisplus.dto;

import java.io.Serializable;

public class QueryCondition5 implements Serializable {

    private String dateStr;
    private int deptno;

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = "'"+dateStr+"'";
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        return "QueryCondition5{" +
                "dateStr='" + dateStr + '\'' +
                ", deptno=" + deptno +
                '}';
    }
}
