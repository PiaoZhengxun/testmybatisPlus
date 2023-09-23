package com.neusoft.testmybatisplus.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@ToString
public class QueryCondition2 implements Serializable {

    private Integer deptno;
    private String ename;


}
