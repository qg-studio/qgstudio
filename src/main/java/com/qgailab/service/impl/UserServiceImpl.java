package com.qgailab.service.impl;

import com.qgailab.dao.UserMapper;
import com.qgailab.model.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-25 15:37
 */
@Slf4j
@Service
public class UserServiceImpl {
    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/user")
    public void test(){
        User user = new User();
        user.setUsername("test");
        userMapper.insertSelective(user);
        System.out.println("user");
    }
}
