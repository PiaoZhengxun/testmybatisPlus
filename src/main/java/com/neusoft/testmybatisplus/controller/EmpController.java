package com.neusoft.testmybatisplus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.neusoft.testmybatisplus.dto.*;
import com.neusoft.testmybatisplus.entity.Emp;
import com.neusoft.testmybatisplus.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yhc
 * @since 2023-09-18
 */
//@CrossOrigin
@RestController
@RequestMapping("/testmybatisplus/emp")
public class EmpController {


    @Autowired
    IEmpService iEmpService;



    @GetMapping("getEmplistByEnameAndEmpno")
    public Message getEmplistByEnameAndEmpno(QueryCondition3 queryCondition3){
        Message message=iEmpService.findEmpByEnameAndEmpno(queryCondition3);
        return message;
    }

    @GetMapping("getEmplistBySal")
    public Message getEmplistBySal(Integer sal){
        Message message=iEmpService.findeBySal(sal);
        return message;
    }





    @GetMapping("getEmplistByCondition2")
    public Message findeByCondition2(QueryCondition2 queryCondition2){
        Message message=iEmpService.findeByCondition2(queryCondition2);
        return message;
    }




    @GetMapping("getEmplistByCondition1")
    public Message getEmplistByCondition1(QueryCondition1 queryConditon1){
        Message message=iEmpService.getEmplistByCondition1(queryConditon1);
        return message;
    }





    @GetMapping("getAllEmps2")
    public Message getAllEmps2(){
        Message message=iEmpService.getAllEmps2();
        return message;
    }

    @GetMapping("getAllEmps3")
    public Message getAllEmps3(){
        Message message=iEmpService.getAllEmps3();
        return message;
    }



    @GetMapping("getAllEmps")
    public Message getAllEmps(){
        Message message=new Message();
        List<Emp> list=iEmpService.list();
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
    public Message insertEmp(@RequestBody  Emp emp){
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
    @GetMapping("getEmpDept")
    public Message getEmpDept(){
        Message message=iEmpService.getEmpDept();

        return message;
    }


    //  getEmpByEmpno
    @GetMapping("getEmpByEmpno")
    public Message getEmpByEmpno(int empno){
        Message message=iEmpService.getEmpByEmpno(empno);
        return message;
    }


    @GetMapping("getEmpByEmpno3")
    public Message getEmpByEmpno3(int empno3){
        Message message=iEmpService.getEmpByEmpno3(empno3);
        return message;
    }
    @GetMapping("getEmpByEmpno4")
    public Message getEmpByEmpno4(int empno4){
        Message message=iEmpService.getEmpByEmpno4(empno4);
        return message;
    }

    @GetMapping("getEmpByEmpno5")
    public Message getEmpByEmpno5(int empno5){
        Message message=new Message();
        Emp emp= iEmpService.getById(empno5);;
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

    @GetMapping("getEmpBySal")
    public Message getEmpBySal(int lowsal,int highsal){
        Message message=iEmpService.getEmpBySal(lowsal,highsal);

        return message;

    }


    @PostMapping("getEmpsByQueryCondition2")
    public Message getEmpsByQueryCondition2(@RequestBody QueryCondition2 queryCondition2){
        System.out.println("queryCondition2:"+queryCondition2);
        Message message=iEmpService.getEmpsByQueryCondition2(queryCondition2);
        return message;
    }
    @PostMapping("getEmpsByQueryCondition5")
    public Message getEmpsByQueryCondition5(@RequestBody QueryCondition5 queryCondition5){
//        queryCondition5.setDateStr("'"+queryCondition5.getDateStr()+"'");
        System.out.println("queryCondition5:"+queryCondition5);
        Message message=iEmpService.getEmpsByQueryCondition5(queryCondition5);
        return message;
    }

    @PostMapping("getEmpsByQueryCondition6")
    public Message getEmpsByQueryCondition6(@RequestBody QueryCondition6 queryCondition6){
        System.out.println("queryCondition6:"+queryCondition6);

       Message message= iEmpService.getEmpsByQueryCondition6(queryCondition6);
       return message;
    }

    @PostMapping("getEmpsByQueryCondition62")
    public Message getEmpsByQueryCondition62(@RequestBody QueryCondition6 queryCondition62){
        System.out.println("queryCondition62"+queryCondition62);

        Message message= iEmpService.getEmpsByQueryCondition62(queryCondition62);
        return message;
    }
    @PostMapping("getEmpsByQueryCondition63")
    public Message getEmpsByQueryCondition63(@RequestBody QueryCondition6 queryCondition63){
        System.out.println("queryCondition63"+queryCondition63);

        Message message= iEmpService.getEmpsByQueryCondition63(queryCondition63);
        return message;
    }

    @PostMapping("getEmpsByIdsAndLimit")
    public Message getEmpsByIdsAndLimit(@RequestBody QueryCondition7 queryCondition7){
        System.out.println("queryCondition7"+queryCondition7);

        Message message= iEmpService.getEmpsByIdsAndLimit(queryCondition7.getIds());
        return message;
    }

    @PostMapping("getEmpsByQueryCondition64")
    public Message getEmpsByQueryCondition64(@RequestBody QueryCondition6 queryCondition64){
        System.out.println("queryCondition64"+queryCondition64);

        Message message= iEmpService.getEmpsByQueryCondition64(queryCondition64);
        return message;
    }

    @PostMapping("getEmpGroupbySum")
    public Message getEmpGroupbySum(@RequestBody QueryCondition8 queryCondition8){
        System.out.println("queryCondition8"+queryCondition8);

        Message message= iEmpService.getEmpGroupbySum(queryCondition8.getSumval());
        return message;
    }


}

