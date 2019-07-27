package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Award;
import com.qgailab.model.po.Intro;
import com.qgailab.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 08:29
 */
@RestController
@RequestMapping(value = "/award")
public class AwardController {

    @Autowired
    private AwardService awardService;

    /**
    * @name 插入奖项
    * @param
    * @return ServiceResult
    * @notice none
    * @author < a href=" ">郭沛</ a>
    * @date
    */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ServiceResult insertAward(@RequestBody Award award) {
        return awardService.insertAward(award);
    }

    /**
     * @name 更新奖项
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ServiceResult updateAward(@RequestBody Award award) {
        return awardService.updateAward(award);
    }

    /**
     * @name 删除奖项
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/remove")
    public ServiceResult removeAward(Long awardId) {
        return awardService.removeAward(awardId);
    }

    /**
     * @name 查询奖项
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/select")
    public ServiceResult selectAward(Long awardId) {
        return awardService.selectAward(awardId);
    }

    /**
     * 分页查询首页信息
     *
     * @param page     页数
     * @param pageSize 一页的最大记录数
     * @return
     * @name listAward
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/list",method = {RequestMethod.POST, RequestMethod.GET})
    public ServiceResult listAward(int page, int pageSize) {
        return awardService.listAward(page, pageSize);
    }

}
