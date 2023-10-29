package com.neusoft.testmybatisplus.service.impl;


import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.service.UploadService;
import org.springframework.stereotype.Service;

@Service
public class UploadServiceimpl  implements UploadService {


    @Override
    public Message savePicUrl(String picname) {
       Message message=new Message();
        // save pic by Dao
        String picserver="http://127.0.0.1:8082/img/";

        String picurl=picserver+picname;

        System.out.println(picurl);


        message.setStatusCode(200);
        message.setMsg("ok");
        message.setObj(picurl);
        return message;
    }






}
