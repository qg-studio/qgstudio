package com.qgailab.util;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description 用于检测数据
 * @date 2019-07-29 22:30
 */
public class ValidationUtils {


    /**
     * 校验数据是否在varchar类型的限制长度内
     *
     * @return
     * @name inTitleSize
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-29
     */
    public static boolean inMaxVarcharSize(String data) {
        if (data == null) {
            return true;
        } else if (data.length() > 200) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 校验数据是否在text类型的限制长度内
     *
     * @return
     * @name inTitleSize
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-29
     */
    public static boolean inMaxTextSize(String data){
        if (data == null) {
            return true;
        } else if (data.length() > 10000) {
            return false;
        } else {
            return true;
        }
    }



}
