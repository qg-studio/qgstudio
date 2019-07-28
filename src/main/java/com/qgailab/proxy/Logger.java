package com.qgailab.proxy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description 负责打印日志
 * @date 2019-07-28 19:44
 */
@Aspect
public class Logger {

    @AfterReturning(value = "execution(* com.qgailab.service.impl.*ServiceImpl.remove*(..))")
    public void afterOperate(){


    }

}
