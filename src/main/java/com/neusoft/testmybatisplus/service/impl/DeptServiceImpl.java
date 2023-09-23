package com.neusoft.testmybatisplus.service.impl;

import com.neusoft.testmybatisplus.entity.Dept;
import com.neusoft.testmybatisplus.mapper.DeptMapper;
import com.neusoft.testmybatisplus.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author junghoon
 * @since 2023-09-21
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
