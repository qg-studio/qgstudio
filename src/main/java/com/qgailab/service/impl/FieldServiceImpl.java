package com.qgailab.service.impl;

import com.qgailab.dao.FieldMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Feature;
import com.qgailab.model.po.Field;
import com.qgailab.service.FieldService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @name InsertField
     * @param  field
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult insertField(Field field) {
        if (field == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (fieldMapper.insertSelective(field) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, field);
    }

    /**
     * @name RemoveField
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult removeField(Long id) {
        Field field ;
        try {
            field = fieldMapper.selectByPrimaryKey(id);
            if (field == null) {
                return new ServiceResult(401, Message.patent_not_found);
            }
            if (fieldMapper.deleteByPrimaryKey(id) != 1){
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success);
    }

    /**
     * @name SelectField
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult selectField(Long id) {
        Field field;
        try {
            field = fieldMapper.selectByPrimaryKey(id);
            if (field == null) {
                return new ServiceResult(401, Message.patent_not_found);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }

        return new ServiceResult(200, Message.success, field);
    }

    /**
     * @name UpdateField
     * @param  field
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult updateField(Field field) {
        if (field == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (fieldMapper.updateByPrimaryKeySelective(field) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, field);
    }
}
