package com.neusoft.testmybatisplus.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class QueryCondition3 implements Serializable {
    private String ename;
    private Integer empno;
}
