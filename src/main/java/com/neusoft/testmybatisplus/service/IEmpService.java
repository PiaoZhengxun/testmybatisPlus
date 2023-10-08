package com.neusoft.testmybatisplus.service;

import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.dto.QueryCondition1;
import com.neusoft.testmybatisplus.dto.QueryCondition2;
import com.neusoft.testmybatisplus.dto.QueryCondition3;
import com.neusoft.testmybatisplus.entity.Emp;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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

    public Message findByCondition2(QueryCondition2 queryCondition2);

    public Message findBySal(int sal);

    public Message findEmpByEnameAndEmpno(QueryCondition3 queryCondition3);

    public Message getAllEmps3();

    public Message getEmpByEmpno3(int empno);

    public Message getEmplistByCondition3(QueryCondition1 queryConditon1);

    public Message  findEmpByEnameAndEmpno3(QueryCondition3 queryCondition3);

    public Message  insertEmp(Emp emp);
    public Message  updateEmp(Emp emp);
    public Message  deleteEmp(int empno);

    public Message  getEmpDeptByEmpno(int empno);

}
