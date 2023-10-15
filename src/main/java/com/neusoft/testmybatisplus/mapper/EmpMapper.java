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

    @Select("select * from emp where deptno=#{empno} ")
    public Emp getEmpByDeptno(int deptno);




    public List<Emp> findByCondtion(QueryCondition1 queryConditon1);
    //multi-condition query
    // select * from emp where ename like '%S%'
    // and  deptno=10
    public List<Emp> findeByCondition2(QueryCondition2 queryCondition2);
    // select * from emp where sal>2000  -->sal>#{sal}
    public List<Emp> findeBySal(int sal);
    // input ename empno
    //select count(*) from emp
    // where ename=#{ename} and empno=#{empno}
    public int  findEmpByEnameAndEmpno(QueryCondition3 queryCondition3);

    @Select("select * from emp")
    public List<Emp> findAll3();



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

    // select * from emp  where deptno=20
    // select * from dept where deptno=20
    // select * from emp join dept on (emp.deptno=dept.deptno)

    // where empno=#{empno}

//        <resultMap id="empdeptMap" type="Emp">
//        <id property="empno" column="empno"/>
//        <result property="ename" column="ename"/>
//        <result property="job" column="job"/>
//        <result property="mgr" column="mgr"/>
//        <result property="hiredate" column="hiredate"/>
//        <result property="sal" column="sal"/>
//        <result property="comm" column="comm"/>
//        <result property="deptno" column="deptno"/>
//        <association property="dept" javaType="Dept">
//            <id property="deptno" column="deptno"/>
//            <result property="dname" column="dname"/>
//            <result property="loc" column="loc"/>
//        </association>
//    </resultMap>

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



    public Emp getEmpByEmpno(int empno);

    @Select("select * from emp where empno=#{empno} ")
    public Emp getEmpByEmpno3(int empno);





}
