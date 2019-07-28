package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Intro;
import com.qgailab.service.constants.Message;
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
     *
     * @name insertIntro
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult insertIntro(Intro intro);


    /**
     * 获取一个信息
     *
     * @name selectIntro
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult selectIntro(Long introId);

    /**
     * 负责更新一条信息点
     *
     * @param intro
     * @name updateIntro
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult updateIntro(Intro intro);

    /**
     * 负责删除一条信息点
     *
     * @param introId
     * @name removeIntro
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult removeIntro(Long introId);

    /**
     * 返回信息点
     *
     * @param page  页数
     * @param pageSize 一页最大记录数
     * @name listIntro
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult listIntro(int page, int pageSize);
}
