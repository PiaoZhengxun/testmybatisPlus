package com.neusoft.testmybatisplus.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class UserinfoDate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "userid", type = IdType.AUTO)
    private Integer userid;


    private String username;

    private String nickname;

    private String password;

    private Integer age;

    private LocalDate hiredate;


    private String email;

    private Integer status;

    private String icon;


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    public LocalDate getHiredate() {
        return hiredate;
    }


    public void setHiredate(LocalDate hiredate) {

        this.hiredate = hiredate;

    }
    public void setHiredateByJavaUtilDate(Date date){
        this.hiredate = changejavautilDateToLocaldate(date);
    }




    private LocalDate changejavautilDateToLocaldate(Date date){
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate;
    }






    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Userinfo{" +
                "userid=" + userid +
                ", username=" + username +
                ", nickname=" + nickname +
                ", password=" + password +
                ", age=" + age +
                ", hiredate=" + hiredate +
                ", email=" + email +
                ", status=" + status +
                ", icon=" + icon +
                "}";
    }

}
