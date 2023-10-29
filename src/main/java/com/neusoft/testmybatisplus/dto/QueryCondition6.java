package com.neusoft.testmybatisplus.dto;

import java.io.Serializable;

public class QueryCondition6 implements Serializable {


    private String startLetter;
    private Double highsal;
    private Double lowsal;

    private Boolean commIsNotNull;

    public Double getLowsal() {
        return lowsal;
    }

    public void setLowsal(Double lowsal) {
        this.lowsal = lowsal;
    }

    public String getStartLetter() {
        return startLetter;
    }

    public void setStartLetter(String startLetter) {
        this.startLetter = startLetter;
    }

    public Double getHighsal() {
        return highsal;
    }

    public void setHighsal(Double highsal) {
        this.highsal = highsal;
    }

    public Boolean getCommIsNotNull() {
        return commIsNotNull;
    }

    public void setCommIsNotNull(Boolean commIsNotNull) {
        this.commIsNotNull = commIsNotNull;
    }

    @Override
    public String toString() {
        return "QueryCondition6{" +
                "startLetter='" + startLetter + '\'' +
                ", highsal=" + highsal +
                ", lowsal=" + lowsal +
                ", commIsNotNull=" + commIsNotNull +
                '}';
    }
}
