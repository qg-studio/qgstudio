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
     * @param
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
     * 分页查询特色
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
