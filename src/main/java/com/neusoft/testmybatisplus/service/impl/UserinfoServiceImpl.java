package com.neusoft.testmybatisplus.service.impl;

import com.neusoft.testmybatisplus.dto.Message;
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
}
