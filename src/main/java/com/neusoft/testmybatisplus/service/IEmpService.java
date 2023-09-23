package com.neusoft.testmybatisplus.service;

import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.dto.QueryCondition1;
import com.neusoft.testmybatisplus.entity.Emp;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junghoon
 * @since 2023-09-21
 */
public interface IEmpService extends IService<Emp> {

    public Message getAllEmps2();

    public Message getEmpByEmpno(int empno);

    public Message getEmplistByCondition1(QueryCondition1 queryCondition1);

}
