package com.qgailab.service.constants;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-26 08:39
 */
public enum Message {

    /*
     **************************************************************
     *              用户
     **************************************************************
     */
    /**
     * 密码错误
     */
    password_incorrect,
    /**
     * 用户不存在
     */
    account_not_found,


    /*
     **************************************************************
     *              荣誉
     **************************************************************
     */
    /**
     * 专利不存在
     */
    patent_not_found,

    /**
     * 著作权不存在
     */
    copyright_not_found,


    /*
     **************************************************************
     *              关于QG
     **************************************************************
     */


    /*
     **************************************************************
     *              我们
     **************************************************************
     */



    /*
     **************************************************************
     *              成员
     **************************************************************
     */



    /*
     **************************************************************
     *              项目
     **************************************************************
     */




    /*
     **************************************************************
     *              专栏
     **************************************************************
     */


    /*
     **************************************************************
     *              系统
     **************************************************************
     */

    /**
     * 标题不可为空
     */
    title_not_null,
    /**
     * 成功
     */
    success,
    /**
     * 未知错误，请重试
     */
    please_retry,
    /**
     * 数据库出错
     */
    database_exception,
    /**
     * 参数不足
     */
    parameter_not_enough;
}