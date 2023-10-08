package com.neusoft.testmybatisplus.service.impl;

import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.dto.QueryCondition1;
import com.neusoft.testmybatisplus.dto.QueryCondition2;
import com.neusoft.testmybatisplus.dto.QueryCondition3;
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

        List<Emp> list = empMapper.findByCondition1(queryCondition1);

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

    @Override
    public Message findByCondition2(QueryCondition2 queryCondition2) {
        Message message = new Message();

        List<Emp> list = empMapper.findByCondition2(queryCondition2);

        if (list.size() > 0) {
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
    public Message findBySal(int sal) {
        Message message = new Message();

        List<Emp> list = empMapper.findBySal(sal);

        if (list.size() > 0) {
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
    public Message findEmpByEnameAndEmpno(QueryCondition3 queryCondition3) {
        Message message = new Message();

        int num = empMapper.findEmpByEnameAndEmpno(queryCondition3);

        System.out.println("num : " + num);

        if (num == 1) {
            message.setStatusCode(200);
            message.setMsg("ok");
//            message.setObj(list);
        } else {
            message.setStatusCode(400);
            message.setMsg("error");
        }
        return message;
    }

    @Override
    public Message getAllEmps3() {
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
    public Message getEmpByEmpno3(int empno) {
        Message message = new Message();

        Emp emp = empMapper.getEmpByEmpno3(empno);

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
    public Message getEmplistByCondition3(QueryCondition1 queryConditon1) {
        Message message=new Message();
        List<Emp> list=empMapper.findByCondtion3(queryConditon1);

        if(list.size()>0){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(list);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }
        return message;
    }

    @Override
    public Message findEmpByEnameAndEmpno3(QueryCondition3 queryCondition3) {
        Message message=new Message();


        int num=empMapper.findEmpByEnameAndEmpno3(queryCondition3);
        System.out.println("num:"+num);

        if(num==1){
            message.setStatusCode(200);
            message.setMsg("ok");
        }else{
            message.setStatusCode(500);
            message.setMsg("error");

        }
        return message;
    }

    @Override
    public Message insertEmp(Emp emp) {
        Message message=new Message();

        int num = empMapper.insertToEmp(emp);

        if(num==1){
            message.setStatusCode(200);
            message.setMsg("ok");
        }else{
            message.setStatusCode(500);
            message.setMsg("error");

        }
        return message;
    }

    @Override
    public Message updateEmp(Emp emp) {
        Message message=new Message();

        int num = empMapper.updateToEmp(emp);

        if(num==1){
            message.setStatusCode(200);
            message.setMsg("ok");
        }else{
            message.setStatusCode(500);
            message.setMsg("error");

        }
        return message;
    }

    @Override
    public Message deleteEmp(int empno) {
        Message message = new Message();

        int num = empMapper.deleteToEmp(empno);

        if (num == 1) {
            message.setStatusCode(200);
            message.setMsg("ok");
        } else {
            message.setStatusCode(500);
            message.setMsg("error");

        }
        return message;

    }

    @Override
    public Message getEmpDeptByEmpno(int empno) {
        Message message = new Message();
        Emp emp=empMapper.findEmpDeptByEmpno(empno);


        if(emp!=null){
            message.setStatusCode(200);
            message.setMsg("ok");
            message.setObj(emp);
        }else{
            message.setStatusCode(400);
            message.setMsg("error");
        }

        return message;

    }
}
