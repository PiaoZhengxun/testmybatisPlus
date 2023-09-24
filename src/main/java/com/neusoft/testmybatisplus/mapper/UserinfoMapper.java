package com.neusoft.testmybatisplus.mapper;

import com.neusoft.testmybatisplus.dto.DeptInfo;
import com.neusoft.testmybatisplus.dto.QueryCondition4;
import com.neusoft.testmybatisplus.entity.Userinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author junghoon
 * @since 2023-09-24
 */
@Mapper
@Repository
public interface UserinfoMapper extends BaseMapper<Userinfo> {

    public int insertUserInfo(Userinfo userinfo);
    public int insertUserInfo2(Userinfo userinfo);
    public int insertUserInfo22(Userinfo userinfo);

    public List<Userinfo> verifyUserinfo(Userinfo userinfo);

    //update userinfo by userid
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

}
