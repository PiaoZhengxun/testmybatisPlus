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
 * @author junghoon
 * @since 2023-09-21
 */
@RestController
@RequestMapping("/testmybatisplus/dept")
public class DeptController {

    @Autowired
    IDeptService iDeptService;

    @GetMapping("findDeptEmpByDeptno")
    public Message findDeptEmpByDeptno(int deptno) {
        Message message = iDeptService.findDeptEmpByDeptno(deptno);
        return message;
    }

}

