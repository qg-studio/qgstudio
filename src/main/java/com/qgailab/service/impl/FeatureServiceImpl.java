package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.dao.FeatureMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Award;
import com.qgailab.model.po.Feature;
import com.qgailab.model.po.Moment;
import com.qgailab.service.FeatureService;
import com.qgailab.service.constants.Message;
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
    public ServiceResult insertFeature(Feature feature) {
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
     * 删除QG特色
     * @name RemoveFeature
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult removeFeature(Long id) {

        Feature feature ;
        try {
            //检查是否存在
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
     * 更新QG特色
     * @name UpdateFeature
     * @param  feature
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult updateFeature(Feature feature) {
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
        if (page < 0 ){
            return new ServiceResult(400, Message.page_invalid);
        }
        List<Feature> featureList;
        try {
            PageHelper.startPage(page, pageSize);
            featureList = featureMapper.listPage(page * pageSize, pageSize);
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, featureList);
    }
}
