package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Field;
import com.qgailab.model.po.History;
import com.qgailab.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 10:03
 */
@RestController
@RequestMapping(value = "/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;
    /**
     * @param
     * @return ServiceResult
     * @name 插入大事记信息
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult insertHistory(@RequestBody History history) {
        return historyService.insertHistory(history);
    }

    /**
     * 更新大事记信息
     *
     * @name updateHistory
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult updateHistory(@RequestBody History history) {
        return historyService.updateHistory(history);
    }



    /**
     * 删除大事记信息
     *
     * @name removeHistory
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult removeHistory(Long historyId) {
        return historyService.removeHistory(historyId);
    }


    /**
     * 分页查询大事记信息
     *
     * @param page     页数
     * @param pageSize 一页的最大记录数
     * @return
     * @name listHistory
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public ServiceResult listHistory(int page, int pageSize) {
        return historyService.listHistory(page, pageSize);
    }
}
