package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-29 09:59
 */
@Controller
@RequestMapping(value = "/log")
public class LogController {
    @Autowired
    private LogService logService;

    /**
     * 查询日志
     *
     * @return
     * @name listLog
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-29
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    ServiceResult listLog(Integer page, Integer pageSize) {
        return logService.listLog(page, pageSize);
    }

    /**
     * 跳转日志页面
     *
     * @return
     * @name showLog
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-29
     */
    @RequestMapping(value = "/show", method = {RequestMethod.POST, RequestMethod.GET})
    public String showLog() {
        return "redirect:/html/log.html";
    }
}