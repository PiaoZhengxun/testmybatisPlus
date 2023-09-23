package com.neusoft.testmybatisplus.dto;

import java.io.Serializable;

public class QueryCondition1 implements Serializable {

    private int empno;
    private int deptno;

    @Override
    public String toString() {
        return "QueryCondition1{" +
                "empno=" + empno +
                ", deptno=" + deptno +
                '}';
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }
}
