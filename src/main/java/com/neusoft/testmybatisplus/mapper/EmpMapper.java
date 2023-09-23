package com.neusoft.testmybatisplus.mapper;

import com.neusoft.testmybatisplus.dto.QueryCondition1;
import com.neusoft.testmybatisplus.dto.QueryCondition2;
import com.neusoft.testmybatisplus.dto.QueryCondition3;
import com.neusoft.testmybatisplus.entity.Emp;
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

}
