package com.qgailab.dao;

import com.qgailab.model.po.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-25 15:29
 */
@Repository
public interface UserDao {

    /**
     * 用户登录
     * @param id
     * @return
     */
    User getUserById (BigInteger id);


}
