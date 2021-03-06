package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.annotation.Permmision;
import com.qgailab.dao.FieldMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Field;
import com.qgailab.service.FieldService;
import com.qgailab.service.constants.Message;
import com.qgailab.service.constants.Module;
import com.qgailab.service.constants.Operation;
import com.qgailab.util.UUIDUtils;
import com.qgailab.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 领域方面的增删查改
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-26 17:25
 */
@Service
public class FieldServiceImpl implements FieldService {

    @Autowired
    private FieldMapper fieldMapper;

    /**
     * 插入领域
     * @name InsertField
     * @param  field
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    @Permmision(module = Module.field,operation = Operation.INSERT)
    public ServiceResult insertField(Field field) {
        if (field == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (field.getName() == null) {
                return new ServiceResult(401,Message.name_not_null);
            }
            if (field.getDescription() == null || field.getDescription().trim().isEmpty()) {
                field.setDescription("");
            }
            String message = validate(field);
            if(message!=null){
                return new ServiceResult(402,message,field);
            }
            field.setUuid(UUIDUtils.getUUID());
            if (fieldMapper.insertSelective(field) != 1) {
                return new ServiceResult(403, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, field);
    }

    /**
     * 移除领域
     * @name RemoveField
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    @Permmision(module = Module.field,operation = Operation.REMOVE)
    public ServiceResult removeField(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Field field ;
        try {
            field = fieldMapper.selectByPrimaryKey(id);
            if (field == null) {
                return new ServiceResult(401, Message.field_not_found);
            }
            if (fieldMapper.deleteByPrimaryKey(id) != 1){
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success,field);
    }

    /**
     * 查询领域
     * @name SelectField
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult selectField(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Field field;
        try {
            field = fieldMapper.selectByPrimaryKey(id);
            if (field == null) {
                return new ServiceResult(401, Message.field_not_found);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }

        return new ServiceResult(200, Message.success, field);
    }

    /**
     * 更新领域
     * @name UpdateField
     * @param  field
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    @Permmision(module = Module.field,operation = Operation.UPDATE)
    public ServiceResult updateField(Field field) {
        if (field == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (field.getId() == null) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            String message = validate(field);
            if(message!=null){
                return new ServiceResult(402,message,field);
            }
            if (fieldMapper.selectByPrimaryKey(field.getId()) == null) {
                return new ServiceResult(403, Message.field_not_found);
            }
            if (field.getDescription() == null || field.getDescription().trim().isEmpty()) {
                field.setDescription("");
            }
            if (fieldMapper.updateByPrimaryKeySelective(field) != 1) {
                return new ServiceResult(404, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, field);
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
    public ServiceResult listField(int page, int pageSize) {
        if (page <= 0 ){
            return new ServiceResult(400, Message.page_invalid);
        }
        if (pageSize <= 0) {
            return new ServiceResult(400, Message.pageSize_invalid);
        }
        List<Field> fieldList;
        try {
            PageHelper.startPage(page, pageSize);
            fieldList = fieldMapper.listPage(page * pageSize, pageSize);
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success,fieldList);
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
    private String validate(Field field) {
        if (!ValidationUtils.inMaxVarcharSize(field.getName())) {
            return Message.title_too_long.toString();
        }if(!ValidationUtils.inMaxTextSize(field.getDescription())){
            return Message.description_too_long.toString();
        } else {
            return null;
        }
    }
}
