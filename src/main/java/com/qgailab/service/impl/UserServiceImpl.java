package com.qgailab.service.impl;

import com.qgailab.dao.UserMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.User;
import com.qgailab.service.UserService;
import com.qgailab.service.constants.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-25 15:37
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 负责用户登陆功能
     *
     * @name login
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult login(User user) {
        if (user == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        String message =validate(user);
        if(message !=null){
            return new ServiceResult(401,message);
        }

        //数据库中的用户
        User realUser;
        try {
            realUser = userMapper.selectByUsername(user.getUsername());
            //检查账户是否存在
            if (realUser == null) {
                return new ServiceResult(402, Message.account_not_found);
            }
            //检查密码
            if (!realUser.getPassword().equalsIgnoreCase(user.getPassword())) {
                return new ServiceResult(403, Message.password_incorrect);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, realUser);
    }



    private String validate(User user){
        String regex = "[\\w_]{6,20}$";
        if(user==null||!user.getUsername().matches(regex)){
            return Message.username_invalid.toString();
        }
        return null;
    }

}
