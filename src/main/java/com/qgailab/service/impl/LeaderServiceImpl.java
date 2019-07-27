package com.qgailab.service.impl;

import com.qgailab.dao.LeaderMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Leader;
import com.qgailab.service.LeaderService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        try {
            if (leader == null || leader.getName() == null || leader.getName().trim().isEmpty()) {
                return new ServiceResult(400, Message.parameter_not_enough);
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
        Leader leader = leaderMapper.selectByPrimaryKey(id);
        try {
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
        return new ServiceResult(200, Message.success);
    }

    @Override
    public ServiceResult updateLeader(Leader leader) {
        try {
            if (leader == null || leader.getName() == null || leader.getName().trim().isEmpty()) {
                return new ServiceResult(400, Message.parameter_not_enough);
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
}
