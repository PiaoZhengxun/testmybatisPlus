package com.neusoft.testmybatisplus.controller;


import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.entity.Userinfo;
import com.neusoft.testmybatisplus.mapper.UserinfoMapper;
import com.neusoft.testmybatisplus.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author junghoon
 * @since 2023-09-24
 */
@RestController
@RequestMapping("/testmybatisplus/userinfo")
public class UserinfoController {


    @Autowired
    IUserinfoService iUserinfoService;
    @PostMapping("registerUserinfo1")
    public Message registerUserinfo(@RequestBody Userinfo userinfo){
        Message message = iUserinfoService.insertUserinfo(userinfo);
        return message;
    }

}

