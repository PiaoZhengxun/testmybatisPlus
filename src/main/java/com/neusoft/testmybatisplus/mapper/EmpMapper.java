package com.neusoft.testmybatisplus.mapper;

import com.neusoft.testmybatisplus.dto.QueryCondition1;
import com.neusoft.testmybatisplus.dto.QueryCondition2;
import com.neusoft.testmybatisplus.dto.QueryCondition3;
import com.neusoft.testmybatisplus.entity.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author junghoon
 * @since 2023-09-21
 */
@Mapper
@Repository
public interface EmpMapper extends BaseMapper<Emp> {

    public List<Emp> findAll2();

    public Emp getEmpByEmpno(int empno);

    public List<Emp> findByCondition1(QueryCondition1 queryCondition1);

    //multi-condition query
    //select * from emp where ename like '%S%
    // and deptno = 10

    public List<Emp> findByCondition2(QueryCondition2 queryCondition2);

    // selct * from emp where sal>2000

    public List<Emp> findBySal(int sal);

    //input ename empno
    // select count(*) from emp where anem=#{ename} and empno=#{empno}
    public int findEmpByEnameAndEmpno(QueryCondition3 queryCondition3);

    @Select("select * from emp")
    public List<Emp> findAll3();

    @Select("select * from emp where empno=#{empno}")
    public Emp getEmpByEmpno3(int empno);

    @Select(" select * from emp where deptno=#{deptno} or empno=#{empno}")
    public List<Emp> findByCondtion3(QueryCondition1 queryConditon1);

    @Select("select count(*) from emp where ename=#{ename} and empno=#{empno}")
    public int  findEmpByEnameAndEmpno3(QueryCondition3 queryCondition3);

    // insert into emp(ename,sal) values(#{ename},#{sal});

    @Insert(" insert into emp(ename,sal) values(#{ename},#{sal})")
    public int insertToEmp(Emp emp);

    // update emp set ename=#{ename},sal=#{sal} where empno=#{empno}
    @Update("update emp set ename=#{ename},sal=#{sal} where empno=#{empno}")
    public  int updateToEmp(Emp emp);

    // delete from emp where empno=#{empno}
    @Delete("delete from emp where empno=#{empno}")
    public  int deleteToEmp(int empno);

    @Select("select * from emp where empno=#{empno}")
    @Results(id = "empDeptMap" , value={
            @Result(property = "empno",column = "empno"),
            @Result(property = "ename",column = "ename"),
            @Result(property = "job",column = "job"),
            @Result(property = "sal",column = "sal"),
            @Result(property = "hiredate",column = "hiredate"),
            @Result(property = "comm",column = "comm"),
            @Result(property = "mgr",column = "mgr"),
            @Result(property = "deptno",column = "deptno"),
            @Result(property = "dept" ,
                    column = "deptno",
                    one=@One(select="com.neusoft.testmybatisplus.mapper.DeptMapper.findDeptByDeptno"))
    })
    public Emp findEmpDeptByEmpno(int empno);

    @Select("select * from emp ")
    @Results(id = "empDeptMap2" , value={
            @Result(property = "empno",column = "empno"),
            @Result(property = "ename",column = "ename"),
            @Result(property = "job",column = "job"),
            @Result(property = "sal",column = "sal"),
            @Result(property = "hiredate",column = "hiredate"),
            @Result(property = "comm",column = "comm"),
            @Result(property = "mgr",column = "mgr"),
            @Result(property = "deptno",column = "deptno"),
            @Result(property = "dept" ,
                    column = "deptno",
                    one=@One(select="com.neusoft.testmybatisplus.mapper.DeptMapper.findDeptByDeptno"))
    })
    public List<Emp> findEmpDept();

    @Select("select * from emp where deptno=#{deptno}")
    public List<Emp> findEmpByDeptno(int deptno);

}
