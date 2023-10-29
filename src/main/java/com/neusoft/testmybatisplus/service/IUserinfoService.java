package com.neusoft.testmybatisplus.service;

import com.neusoft.testmybatisplus.dto.*;
import com.neusoft.testmybatisplus.entity.Userinfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yhc
 * @since 2023-09-19
 */
public interface IUserinfoService extends IService<Userinfo> {

    public Message insertUserinfo(Userinfo userinfo);
    public Message insertUserinfo2(Userinfo userinfo);

    public Message verifyUserinfo(Userinfo userinfo);
    public Message verifyUserinfoBySelectMap(Userinfo userinfo);

//    public Userinfo getUserinfoByUserid(int userid);
    public Message updateUserinfoByUserid(Userinfo userinfo);
    public Message updateUserinfoByUserid2(Userinfo userinfo);
    public Message updateUserinfoByUserid3(Userinfo userinfo);
    public Message deleteUserinfoByUserid(int userid);

    public Message searchByMultiCondition4(QueryCondition4 queryCondition4);
    public Message searchByMultiCondition42(QueryCondition4 queryCondition4);
    public Message searchByCondition4(QueryCondition4 queryCondition4);



    public Message searchUserinfo();
    public Message searchUserinfoByPageCondition(PageCondition pageCondition);
    public Message searchUserinfoByUserinfoPageCondition(UserinfoPageCondition userinfoPageCondition);
    public Message findUserinfoByUserids(int[] userids);
    public Message findAllDeptInfo();
    public Message findAllDeptInfo2();
    public Message findAllDeptInfo3();

    public Message findEmpDeptByEmpno(int empno);

    public Message insertUserinfo3(Userinfo userinfo);


    public Message insertUserinfo4(UserinfoDate userinfoDate);

    public Message verifyUserinfoFun1(Userinfo userinfo);
    public Message verifyUserinfoFun2(Userinfo userinfo);
    public Message verifyUserinfoFun22(Userinfo userinfo);
    public Message verifyUserinfoFun3(Userinfo userinfo);


}
