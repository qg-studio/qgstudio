package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.annotation.Permmision;
import com.qgailab.dao.MomentMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Member;
import com.qgailab.model.po.Moment;
import com.qgailab.service.MomentService;
import com.qgailab.service.constants.Message;
import com.qgailab.service.constants.Module;
import com.qgailab.service.constants.Operation;
import com.qgailab.util.UUIDUtils;
import com.qgailab.util.ValidationUtils;
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

    /**
     * 负责插入一条重要时刻信息
     *
     * @param moment
     * @name insertMoment
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    @Permmision(module = Module.moment,operation = Operation.INSERT)
    public ServiceResult insertMoment(Moment moment) {
        if (moment == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (moment.getTitle() == null || moment.getTitle().trim().isEmpty()) {
                return new ServiceResult(401, Message.title_not_null);
            }
            String message = validate(moment);
            if(message!=null){
                return new ServiceResult(402,message,moment);
            }
            moment.setUuid(UUIDUtils.getUUID());
            if (momentMapper.insertSelective(moment) != 1) {
                return new ServiceResult(403, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, moment);
    }

    /**
     * 负责删除一条重要时刻信息
     *
     * @param id
     * @name removeMoment
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    @Permmision(module = Module.moment,operation = Operation.REMOVE)

    public ServiceResult removeMoment(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
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

    /**
     * 负责更新一条重要时刻信息
     *
     * @param moment
     * @name updateMoment
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    @Permmision(module = Module.moment,operation = Operation.UPDATE)
    public ServiceResult updateMoment(Moment moment) {
        if (moment == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (moment.getId() == null) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            if (moment.getTitle() == null || moment.getTitle().trim().isEmpty()) {
                return new ServiceResult(402, Message.title_not_null);
            }
            String message = validate(moment);
            if(message!=null){
                return new ServiceResult(403,message,moment);
            }
            if (momentMapper.selectByPrimaryKey(moment.getId()) == null) {
                return new ServiceResult(404, Message.moment_not_found);
            }
            if (momentMapper.updateByPrimaryKeySelective(moment) != 1) {
                return new ServiceResult(405, Message.database_exception);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success,moment);
    }

    /**
     * 负责查询一条重要时刻信息
     *
     * @param id
     * @name selectMoment
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult selectMoment(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Moment moment;
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
        if (page <= 0 ){
            return new ServiceResult(400, Message.page_invalid);
        }
        if (pageSize <= 0) {
            return new ServiceResult(401, Message.pageSize_invalid);
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


    /**
     * 用于校验数据
     *
     * @return
     * @name validate
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-30
     */
    private String validate(Moment moment) {
        if (!ValidationUtils.inMaxVarcharSize(moment.getTitle())) {
            return Message.title_too_long.name();
        } else {
            return null;
        }
    }
}
