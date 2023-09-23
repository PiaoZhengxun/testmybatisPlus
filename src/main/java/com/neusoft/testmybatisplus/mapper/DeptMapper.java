package com.neusoft.testmybatisplus.mapper;

import com.neusoft.testmybatisplus.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
public interface DeptMapper extends BaseMapper<Dept> {

}
