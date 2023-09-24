package com.neusoft.testmybatisplus.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class QueryCondition4 implements Serializable {

    private String username;
    private Integer userid;
}
