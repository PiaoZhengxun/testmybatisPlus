package com.neusoft.testmybatisplus.controller;


import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.dto.QueryCondition1;
import com.neusoft.testmybatisplus.dto.QueryCondition2;
import com.neusoft.testmybatisplus.dto.QueryCondition3;
import com.neusoft.testmybatisplus.entity.Emp;
import com.neusoft.testmybatisplus.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.crypto.interfaces.PBEKey;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author junghoon
 * @since 2023-09-21
 */
@RestController
@RequestMapping("/testmybatisplus/emp")
public class EmpController {

    @Autowired
    IEmpService iEmpService;

    @GetMapping("getEmplistByCondition1")
    public Message getEmplistByCondition1(QueryCondition1 queryCondition1){
        Message message = iEmpService.getEmplistByCondition1(queryCondition1);
        return message;
    }

    @GetMapping("getEmplistByCondition2")
    public Message getEmplistByCondition2(QueryCondition2 queryCondition2){
        Message message = iEmpService.findByCondition2(queryCondition2);
        return message;
    }

    @GetMapping("getEmplistBySal")
    public Message getEmplistBySal(Integer sal){
        Message message = iEmpService.findBySal(sal);
        return message;
    }

    @GetMapping("getEmplistByEnameAndEmpno")
    public Message getEmplistByEnameAndEmpno(QueryCondition3 queryCondition3){
        Message message = iEmpService.findEmpByEnameAndEmpno(queryCondition3);
        return message;
    }


    @GetMapping("getEmpByEmpno")
    public Message getEmpByEmpno(int empno){
        Message message = iEmpService.getEmpByEmpno(empno);
        return message;
    }


    @GetMapping("getAllEmps2")
    public Message getAllEmps2(){
        Message message = iEmpService.getAllEmps2();
        return message;
    }

    @GetMapping("getAllEmps")
    public Message getAllEmps(){

        Message message = new Message();

        List<Emp> list = iEmpService.list();
        if (list.size() >= 0) {
            message.setMsg("ok");
            message.setStatusCode(200);
            message.setObj(list);
        }else {
            message.setStatusCode(400);
            message.setMsg("error");
        }
        return message;
    }

}

