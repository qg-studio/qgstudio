package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Field;
import com.qgailab.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 10:04
 */
@Controller
@RequestMapping(value = "/field")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    /**
     * @name 插入领域信息
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult insertFeature(@RequestBody Field field) {
        return fieldService.insertField(field);
    }

    /**
     * 分页查询首页信息
     *
     * @param page     页数
     * @param pageSize 一页的最大记录数
     * @return
     * @name listField
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    ServiceResult listField(int page, int pageSize) {
        return fieldService.listField(page, pageSize);
    }

}
