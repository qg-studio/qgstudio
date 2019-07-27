package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.dao.MomentMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Moment;
import com.qgailab.service.MomentService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 重要时刻的增删查改
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-26 23:45
 */
@Service
public class MomentServiceImpl implements MomentService {

    @Autowired
    private MomentMapper momentMapper;
    @Override
    public ServiceResult insertMoment(Moment moment) {
        if (moment == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (moment.getTitle() == null || moment.getTitle().trim().isEmpty()) {
                return new ServiceResult(401, Message.title_not_null);
            }
            if (momentMapper.insertSelective(moment) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, moment);
    }

    @Override
    public ServiceResult removeMoment(Long id) {
        Moment moment;
        try {
            moment = momentMapper.selectByPrimaryKey(id);
            if (moment == null) {
                return new ServiceResult(401,Message.moment_not_found);
            }
            momentMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200,Message.success, moment);
    }

    @Override
    public ServiceResult updateMoment(Moment moment) {
        if (moment == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (moment.getTitle() == null || moment.getTitle().trim().isEmpty()) {
                return new ServiceResult(401, Message.title_not_null);
            }
            if (momentMapper.updateByPrimaryKeySelective(moment) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success,moment);
    }

    @Override
    public ServiceResult selectMoment(Long id) {
        Moment moment = null;
        try {
            moment = momentMapper.selectByPrimaryKey(id);
            if (moment == null) {
                return new ServiceResult(401, Message.moment_not_found);
            }
            return new ServiceResult(200, Message.success, moment);
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
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
    public ServiceResult listMoment(int page, int pageSize) {
        if (page < 0 ){
            return new ServiceResult(400, Message.page_invalid);
        }
        List<Moment> momentList;
        try {
            PageHelper.startPage(page, pageSize);
            momentList = momentMapper.listPage(page * pageSize, pageSize);
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, momentList);
    }
}