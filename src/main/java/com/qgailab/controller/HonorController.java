package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Honor;
import com.qgailab.service.HonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author < a href=" ">郭沛</ a>
 * @description
 * @date 2019-07-27 10:03
 */
@RestController
@RequestMapping(value = "/honor")
public class HonorController {

    @Autowired
    private HonorService honorService;

    /**
     * 插入最近的荣誉
     *
     * @name insertHonor
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ServiceResult insertHonor(@RequestBody Honor honor) {
        return honorService.insertHonor(honor);
    }


    /**
     * 更新最近的荣誉
     *
     * @name updateHonor
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ServiceResult updateHonor(@RequestBody Honor honor) {
        return honorService.updateHonor(honor);
    }


    /**
     * 删除最近的荣誉
     *
     * @name removeHonor
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ServiceResult removeHonor(@RequestBody Long honorId) {
        return honorService.removeHonor(honorId);
    }


    /**
     * 分页查询最近的荣誉
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
