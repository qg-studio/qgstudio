package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Feature;
import com.qgailab.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 09:21
 */
@RestController
@RequestMapping(value = "/feature")
public class FeatureController {

    @Autowired
    private FeatureService featureService;

    /**
     * @name 插入特色信息
     * @param feature
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ServiceResult insertFeature(@RequestBody Feature feature) {
        return featureService.insertFeature(feature);
    }

    /**
     * @name 删除特色信息
     * @param  featureId
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ServiceResult removeFeature(Long featureId) {
        return featureService.removeFeature(featureId);
    }

    /**
     * @name 更新特色信息
     * @param  feature
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ServiceResult updateFeature(@RequestBody Feature feature) {
        return featureService.updateFeature(feature);
    }

    /**
     * @name 查询特色信息
     * @param  featureId
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/select")
    public ServiceResult selectFeature(Long featureId) {
        return featureService.selectFeature(featureId);
    }

    /**
     * 分页查询首页信息
     *
     * @param page     页数
     * @param pageSize 一页的最大记录数
     * @return
     * @name listFeature
     * @notice none
     * @author <a href="">gp</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET})
    public ServiceResult listFeature(int page, int pageSize) {
        return featureService.listFeature(page, pageSize);
    }

}
