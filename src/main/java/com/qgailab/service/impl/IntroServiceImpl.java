package com.qgailab.service.impl;

import com.qgailab.dao.IntroMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Intro;
import com.qgailab.service.IntroService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description 负责“关于QG”信息点的CRUD
 * @date 2019-07-26 11:31
 */
@Service
@Transactional
public class IntroServiceImpl implements IntroService {

    @Autowired
    private IntroMapper introMapper;

    /**
     * 负责插入一条信息点
     *
     * @param intro
     * @name insertIntro
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult insertIntro(Intro intro) {
        if (intro == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            //标题不可为空
            if (intro.getTitle() == null || intro.getTitle().trim().isEmpty()) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            if(intro.getDescription()==null||intro.getDescription().trim().isEmpty()){
                intro.setDescription("暂无描述信息");
            }

            if(introMapper.insertSelective(intro)!=1){
                return new ServiceResult(402,Message.database_exception);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200,Message.success,intro);
    }
}