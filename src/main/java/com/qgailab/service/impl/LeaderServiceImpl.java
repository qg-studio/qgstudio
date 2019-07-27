package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.dao.LeaderMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Leader;
import com.qgailab.model.po.Moment;
import com.qgailab.service.LeaderService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 指导老师增删查改
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-26 18:24
 */
@Service
public class LeaderServiceImpl implements LeaderService {

    @Autowired
    private LeaderMapper leaderMapper;

    @Override
    public ServiceResult insertLeader(Leader leader) {
        if (leader == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (leader.getName() == null || leader.getName().trim().isEmpty()) {
                return new ServiceResult(400, Message.name_not_null);
            }
            if (leaderMapper.insertSelective(leader) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, leader);
    }

    @Override
    public ServiceResult deleteLeader(Long id) {
        Leader leader;
        try {
            leader = leaderMapper.selectByPrimaryKey(id);
            if (leader == null) {
                return new ServiceResult(401, Message.leader_not_found);
            }
            if (leaderMapper.deleteByPrimaryKey(id) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, leader);
    }

    @Override
    public ServiceResult updateLeader(Leader leader) {
        if (leader == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (leader.getName() == null || leader.getName().trim().isEmpty()) {
                return new ServiceResult(400, Message.name_not_null);
            }
            if (leaderMapper.updateByPrimaryKeySelective(leader) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, leader);
    }

    @Override
    public ServiceResult selectLeader(Long id) {
        Leader leader = leaderMapper.selectByPrimaryKey(id);
        try {
            if (leader == null) {
                return new ServiceResult(401, Message.leader_not_found);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, leader);
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
    public ServiceResult listLeader(int page, int pageSize) {
        if (page < 0 ){
            return new ServiceResult(400, Message.page_invalid);
        }
        List<Leader> leaderList;
        try {
            PageHelper.startPage(page, pageSize);
            leaderList = leaderMapper.listPage(page * pageSize, pageSize);
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, leaderList);
    }
}