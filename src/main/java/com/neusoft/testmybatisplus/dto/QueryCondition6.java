package com.neusoft.testmybatisplus.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class QueryCondition6 implements Serializable {


    private String startLetter;
    private Double highsal;
    private Double lowsal;

    private Boolean commIsNotNull;


}
