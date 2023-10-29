package com.neusoft.testmybatisplus.service.impl;

import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.entity.Dept;
import com.neusoft.testmybatisplus.mapper.DeptMapper;
import com.neusoft.testmybatisplus.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yhc
 * @since 2023-09-18
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Autowired
    DeptMapper deptMapper;


    @Override
    public Message findDeptEmpByDeptno(int deptno) {
        Message message=new Message();
        Dept dept=deptMapper.findDeptEmpByDeptno(deptno);
        if(dept!=null){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(dept);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }


        return message;

    }

    @Override
    public Message findDeptEmpByDeptno2(int deptno) {
        Message message=new Message();
        Dept dept=deptMapper.findDeptEmpByDeptno2(deptno);
        if(dept!=null){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(dept);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }


        return message;
    }

    @Override
    public Message findDeptEmp() {
        Message message=new Message();
        List<Dept> list=deptMapper.findDeptEmp();
        if(list.size()>1){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }


        return message;
    }


}
