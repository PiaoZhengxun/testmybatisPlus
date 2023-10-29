package com.neusoft.testmybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.neusoft.testmybatisplus.dto.*;
import com.neusoft.testmybatisplus.entity.Emp;
import com.neusoft.testmybatisplus.entity.Userinfo;
import com.neusoft.testmybatisplus.mapper.UserinfoMapper;
import com.neusoft.testmybatisplus.service.IUserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yhc
 * @since 2023-09-19
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements IUserinfoService {

    @Autowired
    UserinfoMapper userinfoMapper;

    @Override
    public Message insertUserinfo(Userinfo userinfo) {

        userinfo.setStatus(1);
        Date date = new Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDate localDate = localDateTime.toLocalDate();
        userinfo.setHiredate(localDate);

        Message message=new Message();
        int num=userinfoMapper.insertUserinfo(userinfo);

        if(num>0){
            message.setStatusCode(200);
            message.setMsg("ok");
        }else{
            message.setStatusCode(500);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message insertUserinfo2(Userinfo userinfo) {
        userinfo.setStatus(1);


        Date date = new Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDate localDate = localDateTime.toLocalDate();
        userinfo.setHiredate(localDate);



        Message message=new Message();
        System.out.println("before "+userinfo);
        int num=userinfoMapper.insertUserinfo22(userinfo);
        System.out.println("after "+userinfo);
        userinfo.setPassword(null);
        userinfo.setHiredate(null);
        userinfo.setAge(0);

        if(num>0){
            message.setStatusCode(200);
            message.setMsg("ok");

            message.setObj(userinfo);
        }else{
            message.setStatusCode(500);
            message.setMsg("error");
        }
        return message;
    }

    @Override
    public Message verifyUserinfo(Userinfo userinfo) {
        Message message=new Message();
        List<Userinfo> list=userinfoMapper.verifyUserinfo(userinfo);

        if(list.size()<1){
            message.setStatusCode(400);
            message.setMsg("Error username or password");
        }else if(list.size()==1){
            Userinfo u1=list.get(0);
            if(u1.getStatus()==1){
                message.setStatusCode(200);
                message.setMsg("ok");
                message.setObj(u1);
            }else if(u1.getStatus()==0){
                message.setStatusCode(501);
                message.setMsg("Contact to system admin");
                message.setObj(u1);
            }
        }else{
            message.setStatusCode(500);
            message.setMsg("system error");
        }


        return message;


    }

    @Override
    public Message verifyUserinfoBySelectMap(Userinfo userinfo) {
        Message message=new Message();

//        LoginUserinfoBean loginUserinfoBean=inputUsernamePassword();

        LoginUserinfoBean loginUserinfoBean=new LoginUserinfoBean();
        loginUserinfoBean.setUsername(userinfo.getUsername());
        loginUserinfoBean.setPassword(userinfo.getPassword());

        Map loginUserinfoMap=new HashMap();
        loginUserinfoMap.put("username",loginUserinfoBean.getUsername());
        loginUserinfoMap.put("password",loginUserinfoBean.getPassword());

        //username=#{username}   map.key=#{map.value}
        List<Userinfo> list=userinfoMapper.selectByMap(loginUserinfoMap);

        if(list.size()<1){
            message.setStatusCode(400);
            message.setMsg("Error username or password");
        }else if(list.size()==1){
            Userinfo u1=list.get(0);
            if(u1.getStatus()==1){
                message.setStatusCode(200);
                message.setMsg("ok");
                message.setObj(u1);
            }else if(u1.getStatus()==0){
                message.setStatusCode(501);
                message.setMsg("Contact to system admin");
                message.setObj(u1);
            }
        }else{
            message.setStatusCode(500);
            message.setMsg("system error");
        }

//        System.out.println(message);
        return message;
    }

    private Userinfo getUserinfoByUserid(int userid){
           return  userinfoMapper.getUserinfoByUserid(userid);
    }

    private Userinfo CheckUserinfoProperties(Userinfo userinfoParam,Userinfo userinfoDB){
        if(userinfoParam.getUsername()==null){
            userinfoParam.setUsername(userinfoDB.getUsername());
        }
        if(userinfoParam.getNickname()==null){
            userinfoParam.setNickname(userinfoDB.getNickname());
        }
        if(userinfoParam.getPassword()==null){
            userinfoParam.setPassword(userinfoDB.getPassword());
        }
        if(userinfoParam.getEmail()==null){
            userinfoParam.setEmail(userinfoDB.getEmail());
        }
        if(userinfoParam.getIcon()==null){
            userinfoParam.setIcon(userinfoDB.getIcon());
        }
        if(userinfoParam.getAge()==null || userinfoParam.getAge()==0){
            userinfoParam.setAge(userinfoDB.getAge());
        }
        if(userinfoParam.getHiredate()==null ){
            userinfoParam.setHiredate(userinfoDB.getHiredate());
        }
        return userinfoParam;
    }


    @Override
    public Message updateUserinfoByUserid(Userinfo userinfo) {
            Message message=new Message();

        Userinfo userinfo1=getUserinfoByUserid(userinfo.getUserid());
        userinfo=CheckUserinfoProperties(userinfo,userinfo1);


        int num=userinfoMapper.updateUserinfoByUserid(userinfo);
        if(num>0){
            message.setStatusCode(200);
            message.setMsg("ok");
        }else{
            message.setStatusCode(500);
            message.setMsg("error");
        }

        return message;

    }

    @Override
    public Message updateUserinfoByUserid2(Userinfo userinfo) {
        Message message=new Message();
//        System.out.println("ByUserid2");
        int num=userinfoMapper.updateUserinfoByUserid2(userinfo);
        if(num>0){
            message.setStatusCode(200);
            message.setMsg("ok");
        }else{
            message.setStatusCode(500);
            message.setMsg("error");
        }
        return message;

    }

    @Override
    public Message updateUserinfoByUserid3(Userinfo userinfo) {
        Message message=new Message();
//        System.out.println("ByUserid2");
        int num=userinfoMapper.updateUserinfoByUserid3(userinfo);
        if(num>0){
            message.setStatusCode(200);
            message.setMsg("ok");
        }else{
            message.setStatusCode(500);
            message.setMsg("error");
        }
        return message;
    }

    @Override
    public Message deleteUserinfoByUserid(int userid) {
        Message message=new Message();
        int num=userinfoMapper.deleteUserinfoByUserid(userid);

        if(num>0){
            message.setStatusCode(200);
            message.setMsg("ok");
        }else{
            message.setStatusCode(500);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message searchByMultiCondition4(QueryCondition4 queryCondition4) {
        Message message=new Message();
        List<Userinfo> list=userinfoMapper.findUserinfoByCondition(queryCondition4);
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message searchByMultiCondition42(QueryCondition4 queryCondition4) {
        Message message=new Message();
        List<Userinfo> list=userinfoMapper.findUserinfoByCondition2(queryCondition4);
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message searchByCondition4(QueryCondition4 queryCondition4) {
        Message message=new Message();
        List<Userinfo> list=userinfoMapper.findUserinfoByCondition4(queryCondition4);
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message searchUserinfo() {
        Message message=new Message();
        QueryWrapper queryWrapper=new QueryWrapper();
        List<Userinfo> list= userinfoMapper.selectList(queryWrapper);
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;

    }

    @Override
    public Message searchUserinfoByPageCondition(PageCondition pageCondition) {
        Message message=new Message();
        QueryWrapper<Userinfo> queryWrapper=new QueryWrapper();
        queryWrapper.orderByAsc("userid");

        IPage<Userinfo> page = new Page<>(pageCondition.getCurrentPage(), pageCondition.getPageSize());
        IPage<Userinfo> empIPage=userinfoMapper.selectPage(page,queryWrapper);

        if(empIPage.getTotal()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(empIPage);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;




    }

    @Override
    public Message findUserinfoByUserids(int[] userids) {
        Message message=new Message();
        List<Userinfo> list=userinfoMapper.findUserinfoByUserids(userids);
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message findAllDeptInfo() {
        Message message=new Message();
        List<DeptInfo> list=userinfoMapper.findAllDeptInfo();
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message findAllDeptInfo2() {
        Message message=new Message();
        List<DeptInfo> list=userinfoMapper.findAllDeptInfo2();
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message findAllDeptInfo3() {

        Message message=new Message();
        List<DeptInfo2> list=userinfoMapper.findAllDeptInfo3();
        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;


    }

    @Override
    public Message findEmpDeptByEmpno(int empno) {
        Message message=new Message();
        Emp emp=userinfoMapper.findEmpDeptByEmpno(empno);
        if(emp!=null){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(emp);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message insertUserinfo3(Userinfo userinfo) {
//        Userinfo userinfo= inputUserinfo();
        userinfo.setStatus(1);
        Date date = new Date();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDate localDate = localDateTime.toLocalDate();
        userinfo.setHiredate(localDate);
        Message message=new Message();
//        int num=userinfoMapper.insertUserinfo(userinfo);
        int num=userinfoMapper.insert(userinfo);
        if(num>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(userinfo);
        }else{
            message.setStatusCode(500);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message insertUserinfo4(UserinfoDate userinfoDate) {

        userinfoDate.setStatus(1);
        Date date = new Date();
//        Instant instant = date.toInstant();
//        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
//        LocalDate localDate = localDateTime.toLocalDate();
        userinfoDate.setHiredateByJavaUtilDate(date);



        Message message=new Message();
        System.out.println("before "+userinfoDate);
        int num=userinfoMapper.insertUserinfo23(userinfoDate);
        System.out.println("after "+userinfoDate);
//        userinfoDate.setPassword(null);
//        userinfoDate.setHiredate(null);
//        userinfoDate.setAge(0);

        if(num>0){
            message.setStatusCode(200);
            message.setMsg("ok");

            message.setObj(userinfoDate);
        }else{
            message.setStatusCode(500);
            message.setMsg("error");
        }
        return message;
    }

    // select * from  userinfo  where username=#{username} and password=#{password}
    @Override
    public Message verifyUserinfoFun1(Userinfo userinfo) {
        Message message=new Message();

//        LoginUserinfoBean loginUserinfoBean=inputUsernamePassword();

        LoginUserinfoBean loginUserinfoBean=new LoginUserinfoBean();
        loginUserinfoBean.setUsername(userinfo.getUsername());
        loginUserinfoBean.setPassword(userinfo.getPassword());

//        Map loginUserinfoMap=new HashMap();
//        loginUserinfoMap.put("username",loginUserinfoBean.getUsername());
//        loginUserinfoMap.put("password",loginUserinfoBean.getPassword());

        QueryWrapper<Userinfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",loginUserinfoBean.getUsername())
        .eq("password",loginUserinfoBean.getPassword());



        //username=#{username}   map.key=#{map.value}
        List<Userinfo> list=userinfoMapper.selectList(queryWrapper);

        if(list.size()<1){
            message.setStatusCode(400);
            message.setMsg("Error username or password");
        }else if(list.size()==1){
            Userinfo u1=list.get(0);
            if(u1.getStatus()==1){
                message.setStatusCode(200);
                message.setMsg("ok");
                message.setObj(u1);
            }else if(u1.getStatus()==0){
                message.setStatusCode(501);
                message.setMsg("Contact to system admin");
                message.setObj(u1);
            }
        }else{
            message.setStatusCode(500);
            message.setMsg("system error");
        }

//        System.out.println(message);
        return message;



    }


    @Override
    public Message verifyUserinfoFun2(Userinfo userinfo) {

        Message message=new Message();
        LoginUserinfoBean loginUserinfoBean=new LoginUserinfoBean();
        loginUserinfoBean.setUsername(userinfo.getUsername());
        loginUserinfoBean.setPassword(userinfo.getPassword());

        QueryWrapper<Userinfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.select("count(*) countnum").eq("username",loginUserinfoBean.getUsername())
                .eq("password",loginUserinfoBean.getPassword()).eq("status",1);

        List<Map<String,Object>> list= userinfoMapper.selectMaps(queryWrapper);
        int countnum=0;
        Iterator<Map<String,Object>> iterator=list.iterator();
        while(iterator.hasNext()){
            Map resultmap=iterator.next();
            long longnum=(long)resultmap.get("countnum");
            countnum=Long.valueOf(longnum).intValue();
        }

        if(countnum<1){
            message.setStatusCode(400);
            message.setMsg("Error username or password");
        }else if(countnum==1){

            message.setStatusCode(200);
            message.setMsg("ok");
        }else{
            message.setStatusCode(500);
            message.setMsg("system error");
        }

//        System.out.println(message);
        return message;



    }
    @Override
    public Message verifyUserinfoFun22(Userinfo userinfo) {

        Message message=new Message();
        LoginUserinfoBean loginUserinfoBean=new LoginUserinfoBean();
        loginUserinfoBean.setUsername(userinfo.getUsername());
        loginUserinfoBean.setPassword(userinfo.getPassword());
        QueryWrapper<Userinfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",loginUserinfoBean.getUsername())
                .eq("password",loginUserinfoBean.getPassword()).eq("status",1);
        int countnum=0;
        countnum= userinfoMapper.selectCount(queryWrapper);
        if(countnum<1){
            message.setStatusCode(400);
            message.setMsg("Error username or password");
        }else if(countnum==1){

            message.setStatusCode(200);
            message.setMsg("ok");
        }else{
            message.setStatusCode(500);
            message.setMsg("system error");
        }

//        System.out.println(message);
        return message;



    }
    @Override
    public Message verifyUserinfoFun3(Userinfo userinfo) {
        Message message=new Message();
        LoginUserinfoBean loginUserinfoBean=new LoginUserinfoBean();
        loginUserinfoBean.setUsername(userinfo.getUsername());
        loginUserinfoBean.setPassword(userinfo.getPassword());
        QueryWrapper<Userinfo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",loginUserinfoBean.getUsername())
                .eq("password",loginUserinfoBean.getPassword()).eq("status",1);
        Userinfo userinfoResult=null;
        int flag=0;
        try {
            userinfoResult = userinfoMapper.selectOne(queryWrapper);
        }catch (Exception e){
            flag=1;
            message.setStatusCode(500);
            message.setMsg(e.getMessage());

        }
        if(flag==1){
            return message;
        }
        if(userinfoResult==null){
            message.setStatusCode(400);
            message.setMsg("Error username or password");
        }else{

            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(userinfoResult);
        }


        return message;
    }


}
