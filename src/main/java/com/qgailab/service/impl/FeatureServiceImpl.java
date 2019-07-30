package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.annotation.Permmision;
import com.qgailab.dao.FeatureMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.*;
import com.qgailab.service.FeatureService;
import com.qgailab.service.ImageService;
import com.qgailab.service.constants.Message;
import com.qgailab.service.constants.Module;
import com.qgailab.service.constants.Operation;
import com.qgailab.util.PageUtils;
import com.qgailab.util.UUIDUtils;
import com.qgailab.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-26 16:58
 */
@Service
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureMapper featureMapper;
    @Autowired
    private ImageService imageService;

    /**
     * 插入QG特色
    * @name InsertFeature
    * @param  feature
    * @return ServiceResult
    * @notice none
    * @author < a href=" ">郭沛</ a>
    * @date
    */
    @Override
    @Permmision(module = Module.feature,operation = Operation.INSERT)
    public ServiceResult insertFeature(Feature feature) {
        if (feature == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (feature.getTitle() == null || feature.getTitle().trim().isEmpty()) {
                return new ServiceResult(401, Message.title_not_null);
            }
            if (feature.getDescription() == null || feature.getDescription().trim().isEmpty()) {
                feature.setDescription("");
            }
            String message = validate(feature);

            if(message!=null){
                return new ServiceResult(402,message,feature);
            }
            feature.setUuid(UUIDUtils.getUUID());
            if (featureMapper.insertSelective(feature) != 1) {
                return new ServiceResult(403, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, feature);
    }

    /**
     * 删除QG特色
     * @name RemoveFeature
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    @Permmision(module = Module.feature,operation = Operation.REMOVE)
    public ServiceResult removeFeature(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Feature feature ;
        try {
            //检查是否存在
            feature = featureMapper.selectByPrimaryKey(id);
            if (feature == null) {
                return new ServiceResult(401, Message.feature_not_found);
            }
            if (featureMapper.deleteByPrimaryKey(id) != 1){
                return new ServiceResult(402, Message.database_exception);
            }
            //同时删除图片

        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success,feature);
    }

    /**
     * 查询QG特色
     * @name SelectFeature
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult selectFeature(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Feature feature ;
        try {
            feature = featureMapper.selectByPrimaryKey(id);
            if (feature == null) {
                return new ServiceResult(401, Message.feature_not_found);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }

        return new ServiceResult(200, Message.success, feature);
    }

    /**
     * 更新QG特色
     * @name UpdateFeature
     * @param  feature
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    @Permmision(module = Module.feature,operation = Operation.UPDATE)
    public ServiceResult updateFeature(Feature feature) {
        if (feature == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (feature.getId() == null) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            if (feature.getDescription() == null || feature.getDescription().trim().isEmpty()) {
                feature.setDescription("");
            }
            String message = validate(feature);
            if(message!=null){
                return new ServiceResult(402,message,feature);
            }
            if (featureMapper.selectByPrimaryKey(feature.getId()) == null) {
                return new ServiceResult(403, Message.feature_not_found);
            }
            if (featureMapper.updateByPrimaryKeySelective(feature) != 1) {
                return new ServiceResult(404, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, feature);
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
    public ServiceResult listFeature(int page, int pageSize) {
        if (page <= 0 ){
            return new ServiceResult(400, Message.page_invalid);
        }
        if (pageSize <= 0) {
            return new ServiceResult(400, Message.pageSize_invalid);
        }
        List<Feature> featureList;
        int count;
        try {
            PageHelper.startPage(page, pageSize);
            featureList = featureMapper.listPage(page * pageSize, pageSize);
            count = featureMapper.selectCount();
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, new PageVO(PageUtils.getPage(count, pageSize), featureList));
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
    private String validate(Feature feature) {
        if (!ValidationUtils.inMaxVarcharSize(feature.getTitle())) {
            return Message.title_too_long.name();
        }if(!ValidationUtils.inMaxTextSize(feature.getDescription())){
            return Message.description_too_long.name();
        } else {
            return null;
        }
    }
}
