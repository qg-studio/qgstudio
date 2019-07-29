package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.dao.HistoryMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.History;
import com.qgailab.model.po.Moment;
import com.qgailab.service.HistoryService;
import com.qgailab.service.constants.Message;
import com.qgailab.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description QG历史的增删查改
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-26 17:58
 */
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;
    /**
     * 插入QG历史
     * @name insertHistory
     * @param  history
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult insertHistory(History history) {
        if (history == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (history.getTitle() == null || history.getTitle().trim().isEmpty()) {
                return new ServiceResult(400, Message.parameter_not_enough);
            }
            if (history.getDescription() == null || history.getDescription().trim().isEmpty()) {
                history.setDescription("");
            }
            history.setUuid(UUIDUtils.getUUID());
            if (historyMapper.insertSelective(history) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, history);
    }

    /**
     * 删除QG历史
     * @name RemoveHistory
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult removeHistory(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        History history;
        try {
            history = historyMapper.selectByPrimaryKey(id);
            if (history == null) {
                return new ServiceResult(401, Message.history_not_found);
            }
            if (historyMapper.deleteByPrimaryKey(id) != 1){
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success,history);
    }

    /**
     * 更新GQ历史
     * @name UpdateHistory
     * @param  history
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult updateHistory(History history) {
        if (history == null ) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (history.getId() == null) {
                return new ServiceResult(400, Message.parameter_not_enough);
            }
            if (historyMapper.selectByPrimaryKey(history.getId()) == null) {
                return new ServiceResult(401, Message.history_not_found);
            }
            if (history.getDescription() == null || history.getDescription().trim().isEmpty()) {
                history.setDescription("");
            }
            if (history.getTitle() == null) {
                return new ServiceResult(401, Message.title_not_null);
            }
            if (historyMapper.updateByPrimaryKeySelective(history) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, history);
    }


    /**
     * 查询QG历史
     * @name SelectHistory
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult selectHistory(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        History history;
        try {
            history = historyMapper.selectByPrimaryKey(id);
            if (history == null) {
                return new ServiceResult(401, Message.history_not_found);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success, history);
    }

    /**
     * 负责查询专利信息
     * @param page  页数
     * @param pageSize 一页最大记录数
     * @return: ServiceResult
     * @Author: gp
     * @Date: 2019/7/26
     */
    @Override
    public ServiceResult listHistory(int page, int pageSize) {
        if (page <= 0 ){
            return new ServiceResult(400, Message.page_invalid);
        }
        if (pageSize <= 0) {
            return new ServiceResult(400, Message.pageSize_invalid);
        }
        List<History> historyList;
        try {
            PageHelper.startPage(page, pageSize);
            historyList = historyMapper.listPage(page * pageSize, pageSize);
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, historyList);
    }
}
