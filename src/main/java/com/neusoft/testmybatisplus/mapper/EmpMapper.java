package com.neusoft.testmybatisplus.mapper;

import com.neusoft.testmybatisplus.dto.QueryCondition1;
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

    public List<Emp> findByCondition(QueryCondition1 queryCondition1);

}
