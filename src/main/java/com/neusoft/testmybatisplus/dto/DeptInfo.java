package com.neusoft.testmybatisplus.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class DeptInfo implements Serializable {

    private int deptno;
    private String deptname;
    private String deptloc;
    private int empcountnum;
}
