package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.annotation.Permmision;
import com.qgailab.dao.HonorMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.History;
import com.qgailab.model.po.Honor;
import com.qgailab.model.po.Moment;
import com.qgailab.service.HonorService;
import com.qgailab.service.constants.Message;
import com.qgailab.service.constants.Module;
import com.qgailab.service.constants.Operation;
import com.qgailab.util.UUIDUtils;
import com.qgailab.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description QG荣誉增删查改
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-26 21:26
 */
@Service
public class HonorServiceImpl implements HonorService {

    @Autowired
    private HonorMapper honorMapper;

    /**
     * 负责插入一条荣誉信息
     *
     * @param honor
     * @name insertHonor
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    @Permmision(module = Module.honor,operation = Operation.INSERT)
    public ServiceResult insertHonor(Honor honor) {
        if (honor == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (honor.getTitle() == null || honor.getTitle().trim().isEmpty()) {
                return new ServiceResult(401, Message.title_not_null);
            }
            if (honor.getDescription() == null || honor.getDescription().trim().isEmpty()) {
                honor.setDescription("");
            }
            String message = validate(honor);
            if(message!=null){
                return new ServiceResult(402,message,honor);
            }
            honor.setUuid(UUIDUtils.getUUID());
            if (honorMapper.insertSelective(honor) != 1) {
                return new ServiceResult(403, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, honor);
    }

    /**
     * 负责查询一条荣誉信息
     *
     * @param id
     * @name selectHonor
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult selectHonor(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Honor honor;
        try {
            honor = honorMapper.selectByPrimaryKey(id);
            if (honor == null) {
                return new ServiceResult(400, Message.honor_not_found);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, honor);
    }

    /**
     * 负责删除一条荣誉信息
     *
     * @param id
     * @name removeHonor
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    @Permmision(module = Module.honor,operation = Operation.REMOVE)
    public ServiceResult removeHonor(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Honor honor;
        try {
            honor = honorMapper.selectByPrimaryKey(id);
            if (honor == null) {
                return new ServiceResult(401, Message.honor_not_found);
            }
            if (honorMapper.deleteByPrimaryKey(id) != 1){
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success,honor);
    }

    /**
     * 负责更新一条荣誉信息
     *
     * @param honor
     * @name updateHonor
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    @Permmision(module = Module.honor,operation = Operation.UPDATE)
    public ServiceResult updateHonor(Honor honor) {
        if (honor == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (honor.getId() == null) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            if (honor.getTitle() == null || honor.getTitle().trim().isEmpty()) {
                return new ServiceResult(402, Message.title_not_null);
            }
            if (honor.getDescription() == null || honor.getDescription().trim().isEmpty()) {
                honor.setDescription("");
            }
            String message = validate(honor);
            if(message!=null){
                return new ServiceResult(403,message,honor);
            }
            if(honorMapper.selectByPrimaryKey(honor.getId())==null){
                return new ServiceResult(404,Message.honor_not_found);
            }
            if (honorMapper.updateByPrimaryKeySelective(honor) != 1) {
                return new ServiceResult(405, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, honor);
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
    public ServiceResult listHonor(int page, int pageSize) {
        if (page <= 0 ){
            return new ServiceResult(400, Message.page_invalid);
        }
        if (pageSize <= 0) {
            return new ServiceResult(400, Message.pageSize_invalid);
        }
        List<Honor> honorList;
        try {
            PageHelper.startPage(page, pageSize);
            honorList = honorMapper.listPage(page * pageSize, pageSize);
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, honorList);
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
    private String validate(Honor honor) {
        if (!ValidationUtils.inMaxVarcharSize(honor.getTitle())) {
            return Message.title_too_long.toString();
        }if(!ValidationUtils.inMaxTextSize(honor.getDescription())){
            return Message.description_too_long.toString();
        } else {
            return null;
        }
    }
}
