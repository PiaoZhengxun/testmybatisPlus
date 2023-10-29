package com.neusoft.testmybatisplus.config;

import com.neusoft.testmybatisplus.dto.LoginUserinfoBean;
import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.entity.Userinfo;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MyCommonUtil {



    public static void printMessage(Message message){
        if(message.getStatusCode()!=200){
            System.err.println(message.getStatusCode());
            System.err.println(message.getMsg());
        }else{
            System.out.println(message.getStatusCode());
            System.out.println(message.getMsg());
            if(message.getObj()!=null){
                if(message.getObj() instanceof Collection){
                    ((Collection) message.getObj()).forEach(System.out::println);
                }else{
                    System.out.println(message.getObj());
                }
            }

        }




    }


    // input username password
    public static Userinfo inputUserinfo(){
        Userinfo userinfo=new Userinfo();
        Scanner scanner=new Scanner(System.in);
        String username=null;
        String password=null;
        String nickname=null;
        String email=null;
        int age=0;

        System.out.println("Input Username:");
        username=scanner.next();
        System.out.println("Input Password:");
        password=scanner.next();
        System.out.println("Input nickname:");
        nickname=scanner.next();
        System.out.println("Input email:");
        email=scanner.next();
        System.out.println("Input age:");
        age=scanner.nextInt();

        userinfo.setUsername(username);
        userinfo.setPassword(password);
        userinfo.setNickname(nickname);
        userinfo.setEmail(email);
        userinfo.setAge(age);



        return userinfo;
    }




    // input username password
    public static  LoginUserinfoBean inputUsernamePassword(){
        LoginUserinfoBean loginUserinfoBean=new LoginUserinfoBean();
        Scanner scanner=new Scanner(System.in);
        String username=null;
        String password=null;
        System.out.println("Input Username:");
        username=scanner.next();
        System.out.println("Input Password:");
        password=scanner.next();
        loginUserinfoBean.setUsername(username);
        loginUserinfoBean.setPassword(password);
        return loginUserinfoBean;
    }




    public static void printList(List list){
        Iterator i=list.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }


}
