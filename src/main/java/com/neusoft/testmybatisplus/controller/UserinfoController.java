package com.neusoft.testmybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.testmybatisplus.dto.*;
import com.neusoft.testmybatisplus.entity.Userinfo;
import com.neusoft.testmybatisplus.mapper.UserinfoMapper;
import com.neusoft.testmybatisplus.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yhc
 * @since 2023-09-19
 */
@RestController
@RequestMapping("/testmybatisplus/userinfo")
public class UserinfoController {

    @Autowired
    IUserinfoService iUserinfoService;

    @PostMapping("registerUserinfo1")
    public Message registerUserinfo1(@RequestBody  Userinfo userinfo){
        Message message=iUserinfoService.insertUserinfo(userinfo);
        return message;
    }



    @PostMapping("registerUserinfo2")
    public Message registerUserinfo2(@RequestBody  Userinfo userinfo){
        Message message=iUserinfoService.insertUserinfo2(userinfo);
        return message;
    }
    @PostMapping("registerUserinfo3")
    public Message registerUserinfo3(@RequestBody  Userinfo userinfo){
        Message message=iUserinfoService.insertUserinfo3(userinfo);
        return message;
    }





    @PostMapping("login")
    public Message login(@RequestBody  Userinfo userinfo){
        Message message=iUserinfoService.verifyUserinfo(userinfo);
        return message;
    }

    @PostMapping("login2")
    public Message login2(@RequestBody  Userinfo userinfo){
        Message message=iUserinfoService.verifyUserinfoBySelectMap(userinfo);
        return message;
    }

    @PostMapping("updateUserinfoByUserid")
    public Message updateUserinfoByUserid(@RequestBody  Userinfo userinfo){
        Message message=iUserinfoService.updateUserinfoByUserid(userinfo);
        return message;
    }

    @PostMapping("updateUserinfoByUserid2")
    public Message updateUserinfoByUserid2(@RequestBody  Userinfo userinfo){
        Message message=iUserinfoService.updateUserinfoByUserid2(userinfo);
        return message;
    }

    @PostMapping("updateUserinfoByUserid3")
    public Message updateUserinfoByUserid3(@RequestBody  Userinfo userinfo){
        Message message=iUserinfoService.updateUserinfoByUserid3(userinfo);
        return message;
    }





    @GetMapping("deleteUserinfoByUserid")
    public Message deleteUserinfoByUserid(int userid){
        Message message=iUserinfoService.deleteUserinfoByUserid(userid);
        return message;
    }

    @GetMapping("searchUserinfo")
    public Message searchUserinfo(){
        Message message=iUserinfoService.searchUserinfo();
        return message;
    }

    @PostMapping("searchUserinfoByUserid")
    public Message searchUserinfoByUserid(@RequestBody Userid userid){
        Message message=new Message();
        QueryWrapper<Userinfo> queryWrapper= new QueryWrapper<>();
        queryWrapper.eq("userid",userid.getUserid());
        Userinfo userinfo=iUserinfoService.getOne(queryWrapper);
        message.setStatusCode(200);
        message.setObj(userinfo);
        message.setMsg("ok");
        return message;
    }

    @PostMapping("searchUserinfoByUserinfoPageCondition")
    public Message searchUserinfoByUserinfoPageCondition(@RequestBody UserinfoPageCondition userinfoPageCondition){
        Message message=iUserinfoService.searchUserinfoByUserinfoPageCondition(userinfoPageCondition);
        return message;
    }


    @GetMapping("searchUserinfoByPageCondition")
    public Message searchUserinfo(PageCondition pageCondition){
        Message message=iUserinfoService.searchUserinfoByPageCondition(pageCondition);
        return message;
    }



    @GetMapping("searchByMultiCondition4")
    public Message searchByMultiCondition4(QueryCondition4 queryCondition4){
        Message message=iUserinfoService.searchByMultiCondition4(queryCondition4);
        return message;
    }
    @GetMapping("searchByMultiCondition42")
    public Message searchByMultiCondition42(QueryCondition4 queryCondition4){
        Message message=iUserinfoService.searchByMultiCondition42(queryCondition4);
        return message;
    }
    @GetMapping("searchByCondition4")
    public Message searchByCondition4(QueryCondition4 queryCondition4){
        Message message=iUserinfoService.searchByCondition4(queryCondition4);
        return message;
    }

    @GetMapping("findUserinfoByUserids")
    public Message findUserinfoByUserids(int[] userids){
        Message message=iUserinfoService.findUserinfoByUserids(userids);
        return message;

    }

    @GetMapping("findAllDeptInfo")
    public Message findAllDeptInfo(){
        Message message=iUserinfoService.findAllDeptInfo();
        return message;
    }

    @GetMapping("findAllDeptInfo2")
    public Message findAllDeptInfo2(){
        Message message=iUserinfoService.findAllDeptInfo2();
        return message;
    }

    @GetMapping("findAllDeptInfo3")
    public Message findAllDeptInfo3(){
        Message message=iUserinfoService.findAllDeptInfo2();
        return message;
    }



    @GetMapping("findEmpDeptByEmpno")
    public Message findEmpDeptByEmpno(int empno){
        Message message=iUserinfoService.findEmpDeptByEmpno(empno);
        return message;
    }

    @PostMapping("login3")
    public Message login3(@RequestBody  Userinfo userinfo){
        Message message=iUserinfoService.verifyUserinfoFun3(userinfo);
        return message;
    }






}

