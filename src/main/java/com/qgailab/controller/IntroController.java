package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Intro;
import com.qgailab.service.IntroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-26 12:15
 */
@Controller
@RequestMapping(value = "/intro")
public class IntroController {
    @Autowired
    private IntroService introService;

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult insertIntro(@RequestBody Intro intro){
        return introService.insertIntro(intro);
    }
}
