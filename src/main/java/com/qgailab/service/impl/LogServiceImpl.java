package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.dao.LogMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Image;
import com.qgailab.model.po.Log;
import com.qgailab.model.po.Member;
import com.qgailab.model.po.PageVO;
import com.qgailab.service.LogService;
import com.qgailab.service.constants.Message;
import com.qgailab.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-29 09:54
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 分页查询日志
     *
     * @param page
     * @param pageSize
     * @return
     * @name listLog
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-29
     */
    @Override
    public ServiceResult listLog(int page, int pageSize) {
        if (page <= 0) {
            return new ServiceResult(400, Message.page_invalid);
        }
        if (pageSize <= 0) {
            return new ServiceResult(401, Message.pageSize_invalid);
        }
        List<Log> logs;
        int count;
        try {
            PageHelper.startPage(page, pageSize);
            logs = logMapper.listPage();
            count= logMapper.selectCount();
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, new PageVO(PageUtils.getPage(count, pageSize), logs));
    }
}
