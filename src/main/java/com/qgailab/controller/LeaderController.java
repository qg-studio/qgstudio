package com.qgailab.controller;

import com.qgailab.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 10:02
 */
@RestController
@RequestMapping(value = "/leader")
public class LeaderController {

    @Autowired
    private LeaderService leaderService;



}
