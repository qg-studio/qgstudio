package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Feature;
import com.qgailab.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 09:21
 */
@Controller
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
    public @ResponseBody
    ServiceResult insertFeature(@RequestBody Feature feature) {
        return featureService.insertFeature(feature);
    }



}
