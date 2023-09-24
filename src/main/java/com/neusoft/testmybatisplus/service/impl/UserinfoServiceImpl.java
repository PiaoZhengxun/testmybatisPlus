package com.neusoft.testmybatisplus.service.impl;

import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.dto.QueryCondition4;
import com.neusoft.testmybatisplus.entity.Userinfo;
import com.neusoft.testmybatisplus.mapper.UserinfoMapper;
import com.neusoft.testmybatisplus.service.IUserinfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author junghoon
 * @since 2023-09-24
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

        Message message = new Message();

        int num = userinfoMapper.insertUserInfo(userinfo);

        if(num > 0 ){
            message.setStatusCode(200);
            message.setMsg("ok");
        } else {
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

        Message message = new Message();
        System.out.println("before" + userinfo);
        int num = userinfoMapper.insertUserInfo22(userinfo);
        System.out.println("after" + userinfo);

        userinfo.setPassword(null);
        userinfo.setHiredate(null);
        userinfo.setAge(0);

        if(num > 0 ){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(userinfo);
        } else {
            message.setStatusCode(500);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message verifyUserinfo(Userinfo userinfo) {

        Message message = new Message();

        List<Userinfo> list = userinfoMapper.verifyUserinfo(userinfo);

        if(list.size() < 1){
            message.setStatusCode(400);
            message.setMsg("Error username or password");
        } else if (list.size() == 1){
            Userinfo u1 = list.get(0);
            if (u1.getStatus() == 1){
                message.setStatusCode(200);
                message.setMsg("ok");
                message.setObj(u1);
            } else if (u1.getStatus() == 0){
                message.setStatusCode(501);
                message.setMsg("contact to system admin");
                message.setObj(u1);
            }
        } else {
            message.setStatusCode(500);
            message.setMsg("system error");
        }
        return message;

    }

    private Userinfo getUserinfoByUserid(int userid){
        return userinfoMapper.getUserinfoByUserid(userid);
    }

    private Userinfo CheckUserinfoProperties(Userinfo userinfoParam, Userinfo userinfoDB){
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
        Message message = new Message();

        Userinfo userinfo1 = getUserinfoByUserid(userinfo.getUserid());
        userinfo = CheckUserinfoProperties(userinfo, userinfo1);

        int num = userinfoMapper.updateUserinfoByUserid(userinfo);
        if(num > 0 ){
            message.setStatusCode(200);
            message.setMsg("ok");
        } else {
            message.setStatusCode(500);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message updateUserinfoByUserid2(Userinfo userinfo) {
        Message message = new Message();

//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        System.out.println("ByUserid2");
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        int num = userinfoMapper.updateUserinfoByUserid2(userinfo);
        if(num > 0 ){
            message.setStatusCode(200);
            message.setMsg("ok");
        } else {
            message.setStatusCode(500);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message deleteUserinfoByUserid(int userid) {
        Message message = new Message();
        int num = userinfoMapper.deleteUserinfoByUserid(userid);
        if(num > 0 ){
            message.setStatusCode(200);
            message.setMsg("ok");
        } else {
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
}
