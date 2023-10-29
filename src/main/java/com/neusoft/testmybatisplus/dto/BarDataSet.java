package com.neusoft.testmybatisplus.dto;

import java.util.Arrays;

public class BarDataSet {


    private String[] xAxisData;
    private Integer[] yAxisData;

    public String[] getxAxisData() {
        return xAxisData;
    }

    public void setxAxisData(String[] xAxisData) {
        this.xAxisData = xAxisData;
    }

    public Integer[] getyAxisData() {
        return yAxisData;
    }

    public void setyAxisData(Integer[] yAxisData) {
        this.yAxisData = yAxisData;
    }

    @Override
    public String toString() {
        return "BarDataSet{" +
                "xAxisData=" + Arrays.toString(xAxisData) +
                ", yAxisData=" + Arrays.toString(yAxisData) +
                '}';
    }
}
