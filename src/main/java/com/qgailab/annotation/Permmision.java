package com.qgailab.annotation;

import com.qgailab.service.constants.Module;
import com.qgailab.service.constants.Operation;

import java.lang.annotation.*;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description 描述当前方法的操作权限
 * @date 2019-07-29 08:05
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Permmision {
    Module module();
    Operation operation();
}
