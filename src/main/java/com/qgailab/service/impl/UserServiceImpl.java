package com.qgailab.service.impl;

import com.qgailab.dao.UserMapper;
import com.qgailab.exception.DaoException;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.User;
import com.qgailab.service.UserService;
import com.qgailab.service.constants.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-25 15:37
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 负责用户登陆功能
     *
     * @name login
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult login(@RequestBody User user) {
        if (user == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        //数据库中的用户
        User realUser;
        try {
            realUser = userMapper.selectByUsername(user.getUsername());
            //检查账户是否存在
            if (realUser == null) {
                return new ServiceResult(401, Message.account_not_found);
            }
            //检查密码
            if (!realUser.getPassword().equalsIgnoreCase(user.getPassword())) {
                return new ServiceResult(402, Message.password_incorrect);
            }
        } catch (DaoException e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.database_exception);
        }
        return new ServiceResult(200, Message.success, realUser);
    }

}
