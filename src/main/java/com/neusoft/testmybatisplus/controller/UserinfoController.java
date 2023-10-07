package com.neusoft.testmybatisplus.controller;


import com.neusoft.testmybatisplus.dto.DeptInfo;
import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.dto.QueryCondition4;
import com.neusoft.testmybatisplus.entity.Userinfo;
import com.neusoft.testmybatisplus.mapper.UserinfoMapper;
import com.neusoft.testmybatisplus.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("registerUserinfo2")
    public Message registerUserinfo2(@RequestBody Userinfo userinfo){
        Message message = iUserinfoService.insertUserinfo2(userinfo);
        return message;
    }

    @PostMapping("login")
    public Message login(@RequestBody Userinfo userinfo){
        Message message = iUserinfoService.verifyUserinfo(userinfo);
        return message;
    }

    @PostMapping("updateUserinfoByUserid")
    public Message updateUserinfoByUserid(@RequestBody Userinfo userinfo){
        Message message = iUserinfoService.updateUserinfoByUserid(userinfo);
        return message;
    }

    @PostMapping("updateUserinfoByUserid2")
    public Message updateUserinfoByUserid2(@RequestBody Userinfo userinfo){
        Message message = iUserinfoService.updateUserinfoByUserid2(userinfo);
        return message;
    }
    @PostMapping("updateUserinfoByUserid3")
    public Message updateUserinfoByUserid3(@RequestBody Userinfo userinfo){
        Message message = iUserinfoService.updateUserinfoByUserid3(userinfo);
        return message;
    }

    @GetMapping("deleteUserinfoByUserid")
    public Message deleteUserinfoByUserid(int userid){
        Message message = iUserinfoService.deleteUserinfoByUserid(userid);
        return message;
    }

    @GetMapping("searchByMultiCondition4")
    public Message searchByMultiCondition4(QueryCondition4 queryCondition4){
        Message message = iUserinfoService.searchByMultiCondition4(queryCondition4);
        return message;
    }

    @GetMapping("searchByMultiCondition42")
    public Message searchByMultiCondition42(QueryCondition4 queryCondition4){
        Message message = iUserinfoService.searchByMultiCondition42(queryCondition4);
        return message;
    }

    @GetMapping("searchByCondition4")
    public Message searchByCondition4(QueryCondition4 queryCondition4){
        Message message = iUserinfoService.searchByCondition4(queryCondition4);
        return message;
    }

    @GetMapping("findUserinfoByUserids")
    public Message findUserinfoByUserids(int[] userids) {
        Message message = iUserinfoService.findUserinfoByUserids(userids);
        return message;
    }

    @GetMapping("findAllDeptInfo")
    public Message findAllDeptInfo() {
        Message message = iUserinfoService.findAllDeptInfo();
        return message;

    }

    @GetMapping("findAllDeptInfo2")
    public Message findAllDeptInfo2() {
        Message message = iUserinfoService.findAllDeptInfo2();
        return message;
    }
    @GetMapping("findAllDeptInfo3")
    public Message findAllDeptInfo3() {
        Message message = iUserinfoService.findAllDeptInfo3();
        return message;
    }

}

