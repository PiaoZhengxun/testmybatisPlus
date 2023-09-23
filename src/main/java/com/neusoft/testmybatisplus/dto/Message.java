package com.neusoft.testmybatisplus.dto;

public class Message {

    private   Integer   statusCode;
    private   String    msg;
    private   Object    obj;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Message{" +
                "statusCode=" + statusCode +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }
}