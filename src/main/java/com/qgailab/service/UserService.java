package com.qgailab.service;

import com.qgailab.exception.DaoException;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.User;
import com.qgailab.service.constants.Message;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-25 15:37
 */
@Service
public interface UserService {
    /**
     * 负责用户登陆功能
     *
     * @name login
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult login( User user);
}
