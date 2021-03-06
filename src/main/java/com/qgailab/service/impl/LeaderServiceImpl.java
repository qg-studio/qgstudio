package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.annotation.Permmision;
import com.qgailab.dao.LeaderMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Field;
import com.qgailab.model.po.Leader;
import com.qgailab.model.po.Moment;
import com.qgailab.service.LeaderService;
import com.qgailab.service.constants.Message;
import com.qgailab.service.constants.Module;
import com.qgailab.service.constants.Operation;
import com.qgailab.util.UUIDUtils;
import com.qgailab.util.ValidationUtils;
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

    /**
     * 负责插入一条指导老师信息
     *
     * @param leader
     * @name insertLeader
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    @Permmision(module = Module.leader,operation = Operation.INSERT)
    public ServiceResult insertLeader(Leader leader) {
        if (leader == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (leader.getName() == null || leader.getName().trim().isEmpty()) {
                return new ServiceResult(401, Message.name_not_null);
            }
            if (leader.getDescription() == null || leader.getDescription().trim().isEmpty()) {
                leader.setDescription("");
            }
            String message = validate(leader);
            if(message!=null){
                return new ServiceResult(402,message,leader);
            }
            leader.setUuid(UUIDUtils.getUUID());
            if (leaderMapper.insertSelective(leader) != 1) {
                return new ServiceResult(403, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, leader);
    }

    /**
     * 负责删除一条指导老师信息
     *
     * @param id
     * @name deleteLeader
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    @Permmision(module = Module.leader,operation = Operation.REMOVE)
    public ServiceResult deleteLeader(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
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

    /**
     * 负责更新一条指导老师信息
     *
     * @param leader
     * @name updateLeader
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    @Permmision(module = Module.leader,operation = Operation.UPDATE)
    public ServiceResult updateLeader(Leader leader) {
        if (leader == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (leader.getId() == null) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            if (leader.getName() == null || leader.getName().trim().isEmpty()) {
                return new ServiceResult(402, Message.name_not_null);
            }
            if (leader.getDescription() == null || leader.getDescription().trim().isEmpty()) {
                leader.setDescription("");
            }
            String message = validate(leader);
            if(message!=null){
                return new ServiceResult(403,message,leader);
            }
            if (leaderMapper.selectByPrimaryKey(leader.getId()) == null) {
                return new ServiceResult(404, Message.leader_not_found);
            }
            if (leaderMapper.updateByPrimaryKeySelective(leader) != 1) {
                return new ServiceResult(405, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, leader);
    }

    /**
     * 负责查询一条指导老师信息
     *
     * @param id
     * @name selectLeader
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult selectLeader(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Leader leader;
        try {
            leader = leaderMapper.selectByPrimaryKey(id);
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
        if (page <= 0 ){
            return new ServiceResult(400, Message.page_invalid);
        }
        if (pageSize <= 0) {
            return new ServiceResult(400, Message.pageSize_invalid);
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

    /**
     * 用于校验数据
     *
     * @return
     * @name validate
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-30
     */
    private String validate(Leader leader) {
        if (!ValidationUtils.inMaxVarcharSize(leader.getName())) {
            return Message.title_too_long.toString();
        }if(!ValidationUtils.inMaxTextSize(leader.getDescription())){
            return Message.description_too_long.toString();
        }
        if (!ValidationUtils.inMaxVarcharSize(leader.getPosition())) {
            return Message.position_too_long.toString();
        } else {
            return null;
        }
    }
}
