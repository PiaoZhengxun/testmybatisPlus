package com.neusoft.testmybatisplus.service;

import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.entity.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junghoon
 * @since 2023-09-21
 */
public interface IDeptService extends IService<Dept> {

    public Message findDeptEmpByDeptno(int deptno);

    public Message findDeptEmpByDeptno2(int deptno);

    public Message findDeptEmp();

}
