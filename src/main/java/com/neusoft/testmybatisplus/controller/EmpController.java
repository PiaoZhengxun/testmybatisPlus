package com.neusoft.testmybatisplus.controller;


import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.dto.QueryCondition1;
import com.neusoft.testmybatisplus.dto.QueryCondition2;
import com.neusoft.testmybatisplus.dto.QueryCondition3;
import com.neusoft.testmybatisplus.entity.Emp;
import com.neusoft.testmybatisplus.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("getAllEmps3")
    public Message getAllEmps3(){
        Message message = iEmpService.getAllEmps3();
        return message;
    }

    @GetMapping("getEmpByEmpno3")
    public Message getEmpByEmpno3(int empno3){
        Message message=iEmpService.getEmpByEmpno3(empno3);
        return message;
    }

    @GetMapping("getEmplistByCondition3")
    public Message getEmplistByCondition3(QueryCondition1 queryConditon1){
        Message message=iEmpService.getEmplistByCondition3(queryConditon1);
        return message;
    }

    @GetMapping("getEmpNumByEnameAndEmpno3")
    public Message getEmpNumByEnameAndEmpno3(QueryCondition3 queryCondition3){
        Message message=iEmpService.findEmpByEnameAndEmpno3(queryCondition3);
        return message;
    }

    @PostMapping("insertEmp")
    public Message insertEmp(@RequestBody Emp emp){
        Message message=iEmpService.insertEmp(emp);
        return message;
    }
    @PostMapping("updateEmp")
    public Message updateEmp(@RequestBody  Emp emp){
        Message message=iEmpService.updateEmp(emp);
        return message;
    }

    @GetMapping("deleteEmp")
    public Message deleteEmp(int empno){
        Message message=iEmpService.deleteEmp(empno);
        return message;
    }

    @GetMapping("getEmpDeptByEmpno")
    public Message getEmpDeptByEmpno(int empno){
        Message message=iEmpService.getEmpDeptByEmpno(empno);

        return message;
    }

}

