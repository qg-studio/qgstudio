package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Copyright;
import com.qgailab.service.CopyrightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 09:11
 */
@Controller
@RequestMapping(value = "/copyright")
public class CopyrightController {

    @Autowired
    private CopyrightService copyrightService;

    /**
    * @name 插入著作权信息
    * @param
    * @return ServiceResult
    * @notice none
    * @author < a href=" ">郭沛</ a>
    * @date
    */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult insertCopyright(@RequestBody Copyright copyright) {
        return copyrightService.insertCopyright(copyright);
    }

    /**
     * @name 更新著作权信息
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult updateCopyright(@RequestBody Copyright copyright) {
        return copyrightService.updateCopyright(copyright);
    }

    /**
     * @name 删除著作权信息
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/remove")
    public @ResponseBody
    ServiceResult removeCopyright(Long copyrightId) {
        return copyrightService.removeCopyright(copyrightId);
    }

    /**
     * @name 查询著作权信息
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/select")
    public @ResponseBody
    ServiceResult selectCopyright(Long copyrightId) {
        return copyrightService.selectCopyright(copyrightId);
    }
}
