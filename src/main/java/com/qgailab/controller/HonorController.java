package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.service.HonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 10:03
 */
@RestController
@RequestMapping(value = "/honor")
public class HonorController {

    @Autowired
    private HonorService honorService;
    /**
     * 分页查询首页信息
     *
     * @param page     页数
     * @param pageSize 一页的最大记录数
     * @return
     * @name listHonor
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    ServiceResult listHonor(int page, int pageSize) {
        return honorService.listHonor(page, pageSize);
    }
}
