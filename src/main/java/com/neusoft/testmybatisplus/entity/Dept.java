package com.neusoft.testmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author yhc
 * @since 2023-09-18
 */
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("DEPTNO")
    private Integer deptno;




    @TableField("DNAME")
    private String dname;

    @TableField("LOC")
    private String loc;


    private List<Emp> emps;

    public List<Emp> getEmps() {
        return emps;
    }



    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                ", emps=" + emps +
                '}';
    }
}
