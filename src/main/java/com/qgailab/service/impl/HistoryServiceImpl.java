package com.qgailab.service.impl;

import com.qgailab.dao.HistoryMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.History;
import com.qgailab.service.HistoryService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            if (history.getTitle() == null || history.getTitle().trim().isEmpty() || history.getTitle().trim().isEmpty()) {
                return new ServiceResult(400, Message.parameter_not_enough);
            }
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
     * @name RemoveHistory
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult RemoveHistory(Long id) {
        History history;
        try {
            history = historyMapper.selectByPrimaryKey(id);
            if (history == null) {
                return new ServiceResult(401, Message.patent_not_found);
            }
            if (historyMapper.deleteByPrimaryKey(id) != 1){
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success);
    }

    /**
     * @name UpdateHistory
     * @param  history
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult UpdateHistory(History history) {
        if (history == null || history.getTitle() == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
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
     * @name SelectHistory
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult SelectHistory(Long id) {
        History history;
        try {
            history = historyMapper.selectByPrimaryKey(id);
            if (history == null) {
                return new ServiceResult(401, Message.patent_not_found);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success, history);
    }
}
