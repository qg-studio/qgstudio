package com.qgailab.model.dto;

import com.qgailab.service.constants.Message;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description 用于返回数据给前端
 * @date 2019-07-26 08:22
 */
public class ServiceResult {
    /**
     * 状态码
     */
    private int status;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    private Object data;

    public ServiceResult(int status, Message message, Object data) {
        this.status = status;
        this.message = message.toString();
        this.data = data;
    }

    public ServiceResult(int status, Message message) {
        this.status = status;
        this.message = message.toString();
    }

    public ServiceResult(int status, Object data) {
        this.status = status;
        this.data = data;
    }

    private ServiceResult(){}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message.toString();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
