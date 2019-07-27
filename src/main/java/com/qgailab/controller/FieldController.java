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
 * @author < a href=" ">郭沛</ a>
 * @description
 * @date 2019-07-27 10:04
 */
@Controller
@RequestMapping(value = "/field")
public class FieldController {

    @Autowired
    private FieldService fieldService;

    /**
     * @param
     * @return ServiceResult
     * @name 插入领域信息
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult insertField(@RequestBody Field field) {
        return fieldService.insertField(field);
    }

    /**
     * 更新研究方向信息
     *
     * @name updateField
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult updateField(@RequestBody Field field) {
        return fieldService.updateField(field);
    }



    /**
     * 删除研究方向信息
     *
     * @name removeField
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult removeField(Long fieldId) {
        return fieldService.removeField(fieldId);
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
