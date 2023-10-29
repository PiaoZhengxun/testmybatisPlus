package com.neusoft.testmybatisplus.controller;


import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yhc
 * @since 2023-09-18
 */
@RestController
@RequestMapping("/testmybatisplus/dept")
public class DeptController {

    @Autowired
    IDeptService iDeptService;

    @GetMapping("findDeptEmpByDeptno")
    public Message findDeptEmpByDeptno(int deptno){
        Message message= iDeptService.findDeptEmpByDeptno(deptno);
        return message;
    }

    @GetMapping("findDeptEmpByDeptno2")
    public Message findDeptEmpByDeptno2(int deptno){
        Message message= iDeptService.findDeptEmpByDeptno2(deptno);
        return message;
    }

    @GetMapping("findDeptEmp")
    public Message findDeptEmp(){
        Message message= iDeptService.findDeptEmp();
        return message;
    }

}

