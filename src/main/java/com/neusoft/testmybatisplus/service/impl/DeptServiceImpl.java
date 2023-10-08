package com.neusoft.testmybatisplus.service.impl;

import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.entity.Dept;
import com.neusoft.testmybatisplus.entity.Emp;
import com.neusoft.testmybatisplus.mapper.DeptMapper;
import com.neusoft.testmybatisplus.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    DeptMapper deptMapper;


    @Override
    public Message findDeptEmpByDeptno(int deptno) {
        Message message=new Message();
        Dept dept= deptMapper.findDeptEmpByDeptno(deptno);
        if(dept != null){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(dept);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;
    }
}
