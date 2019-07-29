package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-29 09:53
 */
public interface LogService {
    /**
     * 分页查询日志
     *
     * @return
     * @name listLog
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-29
     */
    ServiceResult listLog(int page,int pageSize);
}
