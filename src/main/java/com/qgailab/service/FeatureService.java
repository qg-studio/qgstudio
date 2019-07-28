package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Feature;

public interface FeatureService {

    /**
     * 插入QG特色
    * @name InsertFeature
    * @param  feature
    * @return ServiceResult
    * @notice none
    * @author < a href=" ">郭沛</ a>
    * @date
    */
    ServiceResult insertFeature(Feature feature);

    /**
     * 移除QG特色
    * @name RemoveFeature
    * @param  id
    * @return ServiceResult
    * @notice none
    * @author < a href=" ">郭沛</ a>
    * @date
    */
    ServiceResult removeFeature(Long id);

    /**
     * 查询QG特色
     * @name SelectFeature
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult selectFeature(Long id);

    /**
     * 更新某一QG特色
     * @name UpdateFeature
     * @param  feature
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult updateFeature(Feature feature);

    /**
     * 返回信息点
     *
     * @param page  页数
     * @param pageSize 一页最大记录数
     * @name listFeature
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult listFeature(int page, int pageSize);

}
