package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Intro;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description "关于QG"的信息点的CRUD
 * @date 2019-07-26 11:24
 */
@Service
public interface IntroService {

    /**
     * 负责插入一条信息点
     * @name insertIntro
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult insertIntro(Intro intro);
}
