package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Award;
import com.qgailab.model.po.Intro;
import com.qgailab.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 08:29
 */
@Controller
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
    public @ResponseBody
    ServiceResult insertAward(@RequestBody Award award) {
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
    public @ResponseBody
    ServiceResult updateAward(@RequestBody Award award) {
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
    public @ResponseBody
    ServiceResult removeAward(Long awardId) {
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
    public @ResponseBody
    ServiceResult selectAward(Long awardId) {
        return awardService.selectAward(awardId);
    }


}
