package com.neusoft.testmybatisplus.dto;

import com.neusoft.testmybatisplus.entity.Dept;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class DeptInfo2 implements Serializable {

    private int empcountnum;
    private Dept dept;
}
