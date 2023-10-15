package com.neusoft.testmybatisplus.dto;

import com.neusoft.testmybatisplus.entity.Emp;

import java.io.Serializable;

public class EmpGroupByResult extends Emp implements Serializable {


    private Double sumval;
    private Double maxval;
    private Double minval;
    private Double avgval;



    public Double getSumval() {
        return sumval;
    }

    public void setSumval(Double sumval) {
        this.sumval = sumval;
    }

    public Double getMaxval() {
        return maxval;
    }

    public void setMaxval(Double maxval) {
        this.maxval = maxval;
    }

    public Double getMinval() {
        return minval;
    }

    public void setMinval(Double minval) {
        this.minval = minval;
    }

    public Double getAvgval() {
        return avgval;
    }

    public void setAvgval(Double avgval) {
        this.avgval = avgval;
    }

    @Override
    public String toString() {
        return "EmpGroupByResult{" +

                ", sumval=" + sumval +
                ", maxval=" + maxval +
                ", minval=" + minval +
                ", avgval=" + avgval +
                '}';
    }
}
