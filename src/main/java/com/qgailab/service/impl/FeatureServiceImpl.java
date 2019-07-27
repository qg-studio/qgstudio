package com.qgailab.service.impl;

import com.qgailab.dao.FeatureMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Award;
import com.qgailab.model.po.Feature;
import com.qgailab.service.FeatureService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-26 16:58
 */
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureMapper featureMapper;
    /**
    * @name InsertFeature
    * @param  feature
    * @return ServiceResult
    * @notice none
    * @author < a href=" ">郭沛</ a>
    * @date
    */
    @Override
    public ServiceResult InsertFeature(Feature feature) {
        if (feature == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (feature.getTitle() == null || feature.getTitle().trim().isEmpty()) {
                return new ServiceResult(401, Message.title_not_null);
            }
            if (feature.getDescription() == null || feature.getDescription().trim().isEmpty()) {
                feature.setDescription("暂未填写");
            }

            if (featureMapper.insertSelective(feature) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, feature);
    }

    /**
     * @name RemoveFeature
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult RemoveFeature(Long id) {

        Feature feature ;
        try {
            feature = featureMapper.selectByPrimaryKey(id);
            if (feature == null) {
                return new ServiceResult(401, Message.patent_not_found);
            }
            if (featureMapper.deleteByPrimaryKey(id) != 1){
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success);
    }

    /**
     * @name SelectFeature
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult SelectFeature(Long id) {
        Feature feature ;
        try {
            feature = featureMapper.selectByPrimaryKey(id);
            if (feature == null) {
                return new ServiceResult(401, Message.patent_not_found);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }

        return new ServiceResult(200, Message.success, feature);
    }

    /**
     * @name UpdateFeature
     * @param  feature
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult UpdateFeature(Feature feature) {
        if (feature == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (featureMapper.updateByPrimaryKeySelective(feature) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, feature);
    }
}
