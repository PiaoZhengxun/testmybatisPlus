package com.neusoft.testmybatisplus.mapper;

import com.neusoft.testmybatisplus.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neusoft.testmybatisplus.entity.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yhc
 * @since 2023-09-18
 */
@Mapper
@Repository
public interface DeptMapper extends BaseMapper<Dept> {


    public Dept findDeptEmpByDeptno(int deptno);
//
    @Select("select * from dept where deptno=#{deptno}")
    public Dept findDeptByDeptno(int deptno);




    @Select("select * from dept where deptno=#{deptno}")
    @Results(id = "deptempMap2" , value={
            @Result(property = "deptno",column = "deptno"),
            @Result(property = "dname",column = "dname"),
            @Result(property = "loc",column = "loc"),
            @Result(property = "emps" ,
                    column = "deptno",
                    many=@Many(select="com.neusoft.testmybatisplus.mapper.EmpMapper.findEmpByDeptno" )
                 )
    })
    public Dept findDeptEmpByDeptno2(int deptno);


    @Select("select * from dept ")
    @Results(id = "deptempMap3" , value={
            @Result(property = "deptno",column = "deptno"),
            @Result(property = "dname",column = "dname"),
            @Result(property = "loc",column = "loc"),
            @Result(property = "emps" ,
                    column = "deptno",
                    many=@Many(select="com.neusoft.testmybatisplus.mapper.EmpMapper.findEmpByDeptno" )
            )
    })
    public List<Dept> findDeptEmp();



}
