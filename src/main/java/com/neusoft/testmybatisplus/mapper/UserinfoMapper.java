package com.neusoft.testmybatisplus.mapper;

import com.neusoft.testmybatisplus.dto.DeptInfo;
import com.neusoft.testmybatisplus.dto.DeptInfo2;
import com.neusoft.testmybatisplus.dto.QueryCondition4;
import com.neusoft.testmybatisplus.dto.UserinfoDate;
import com.neusoft.testmybatisplus.entity.Emp;
import com.neusoft.testmybatisplus.entity.Userinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yhc
 * @since 2023-09-19
 */
@Mapper
@Repository
public interface UserinfoMapper extends BaseMapper<Userinfo> {


    public int insertUserinfo(Userinfo userinfo);
    public int insertUserinfo2(Userinfo userinfo);
    public int insertUserinfo22(Userinfo userinfo);

    public int insertUserinfo23(UserinfoDate userinfoDate);



    public List<Userinfo> verifyUserinfo(Userinfo userinfo);

    // update userinfoby userid
    public int updateUserinfoByUserid(Userinfo userinfo);
    public int updateUserinfoByUserid2(Userinfo userinfo);
    public int updateUserinfoByUserid3(Userinfo userinfo);


    public Userinfo getUserinfoByUserid(int userid);

    public int deleteUserinfoByUserid(int userid);


    public List<Userinfo> findUserinfoByCondition(QueryCondition4 queryCondition4);
    public List<Userinfo> findUserinfoByCondition2(QueryCondition4 queryCondition4);

    public List<Userinfo> findUserinfoByCondition4(QueryCondition4 queryCondition4);

    public List<Userinfo> findUserinfoByUserids(int[] userids);

    public List<DeptInfo> findAllDeptInfo();

    public List<DeptInfo> findAllDeptInfo2();


    public List<DeptInfo2> findAllDeptInfo3();


    public Emp  findEmpDeptByEmpno(int empno);



}
