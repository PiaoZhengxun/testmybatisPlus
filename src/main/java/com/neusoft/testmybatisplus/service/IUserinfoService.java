package com.neusoft.testmybatisplus.service;

import com.neusoft.testmybatisplus.dto.Message;
import com.neusoft.testmybatisplus.entity.Userinfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.testmybatisplus.mapper.UserinfoMapper;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author junghoon
 * @since 2023-09-24
 */
public interface IUserinfoService extends IService<Userinfo> {

    public Message insertUserinfo(Userinfo userinfo);

}
