package com.neusoft.testmybatisplus.service.impl;

import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.dto.QueryCondition1;
import com.neusoft.testmybatisplus.entity.Emp;
import com.neusoft.testmybatisplus.mapper.EmpMapper;
import com.neusoft.testmybatisplus.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author junghoon
 * @since 2023-09-21
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {


    @Autowired
    EmpMapper empMapper;
    @Override
    public Message getAllEmps2() {

        Message message = new Message();

        List<Emp> list = empMapper.findAll2();

        if (list.size() > 0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        } else {
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }

    @Override
    public Message getEmpByEmpno(int empno) {
        Message message = new Message();

        Emp emp = empMapper.getEmpByEmpno(empno);

        if (emp != null) {
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(emp);
        } else {
            message.setStatusCode(400);
            message.setMsg("error");
        }
        return message;
    }

    @Override
    public Message getEmplistByCondition1(QueryCondition1 queryCondition1) {

        Message message = new Message();

        List<Emp> list =empMapper.findByCondition(queryCondition1);

        if (list != null) {
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        } else {
            message.setStatusCode(400);
            message.setMsg("error");
        }
        return message;
    }
}
