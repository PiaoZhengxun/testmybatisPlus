package com.neusoft.testmybatisplus.controller;

import com.neusoft.testmybatisplus.dto.BarDataSet;
import com.neusoft.testmybatisplus.dto.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testmybatisplus/echart")
public class EChartController {


    @GetMapping("getDataToBar")
    public Message getDataToBar(){
        Message message=new Message();
//        'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'
        String[] x=new String[7];
        x[0]="Mon";
        x[1]="Tue";
        x[2]="Wed";
        x[3]="Thu";
        x[4]="Fri";
        x[5]="Sat";
        x[6]="Sun";

        Integer[] y=new Integer[7];
        y[0]=20;
        y[1]=30;
        y[2]=40;
        y[3]=50;
        y[4]=20;
        y[5]=10;
        y[6]=60;
        BarDataSet barDataSet=new BarDataSet();
        barDataSet.setxAxisData(x);
        barDataSet.setyAxisData(y);

        message.setStatusCode(200);
        message.setMsg("ok");
        message.setObj(barDataSet);

        return message;
    }



}
