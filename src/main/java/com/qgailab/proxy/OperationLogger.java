package com.qgailab.proxy;

import com.qgailab.annotation.Permmision;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.apache.log4j.lf5.viewer.LogFactor5ErrorDialog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description 负责打印日志
 * @date 2019-07-28 19:44
 */
@Aspect
@Component
public class OperationLogger {

    @Autowired
    private HttpSession session;


    @Around(value = "execution(* com.qgailab.service.impl.*ServiceImpl.remove*(..))" +
            "||execution(* com.qgailab.service.impl.*ServiceImpl.update*(..))" +
            "||execution(* com.qgailab.service.impl.*ServiceImpl.insert*(..))")
    public ServiceResult aroundOperate(ProceedingJoinPoint proceedingJoinPoint) {
        User user = (User) session.getAttribute("login");
        user = new User();
        Logger log = Logger.getLogger("LOGDB2");
        Logger fileLogger = Logger.getLogger(proceedingJoinPoint.getTarget().getClass());
        ServiceResult result = null;
        try {
            //获取正在执行的方法和返回值
            MethodSignature ms = (MethodSignature) proceedingJoinPoint.getSignature();
            Method method = proceedingJoinPoint.getTarget().getClass().getDeclaredMethod(ms.getName(), ms.getParameterTypes());
            Object[] args = proceedingJoinPoint.getArgs();
            result = (ServiceResult) proceedingJoinPoint.proceed(args);

            if (method.isAnnotationPresent(Permmision.class)) {
                Permmision permmision = method.getAnnotation(Permmision.class);
                //打印日志
                log.warn("用户[" + user.getUsername() + "] 对[" + permmision.module().getName() + "]执行了[" + permmision.operation().getName() + "]操作");
                fileLogger.warn("用户[" + user.getUsername() + "] 对[" + permmision.module().getName() + "]执行了[" + permmision.operation().getName() + "]操作");
            }

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

}
