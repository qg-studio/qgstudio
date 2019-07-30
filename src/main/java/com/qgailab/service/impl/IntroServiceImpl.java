package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.annotation.Permmision;
import com.qgailab.dao.IntroMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.History;
import com.qgailab.model.po.Intro;
import com.qgailab.model.po.PageVO;
import com.qgailab.service.IntroService;
import com.qgailab.service.constants.Message;
import com.qgailab.service.constants.Module;
import com.qgailab.service.constants.Operation;
import com.qgailab.util.PageUtils;
import com.qgailab.util.UUIDUtils;
import com.qgailab.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Permmision(module = Module.intro,operation = Operation.INSERT)
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
                intro.setDescription("");
            }
            String message = validate(intro);
            if(message!=null){
                return new ServiceResult(402,message,intro);
            }
            intro.setUuid(UUIDUtils.getUUID());

            if(introMapper.insertSelective(intro)!=1){
                return new ServiceResult(403,Message.database_exception);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200,Message.success,intro);
    }

    /**
     * 负责更新一条信息点
     *
     * @param intro
     * @name updateIntro
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    @Override
    @Permmision(module = Module.intro,operation = Operation.UPDATE)
    public ServiceResult updateIntro(Intro intro) {
        if (intro == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (intro.getId() == null) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            if (intro.getDescription() == null || intro.getDescription().trim().isEmpty()) {
                intro.setDescription("");
            }
            String message = validate(intro);
            if(message!=null){
                return new ServiceResult(402,message,intro);
            }
            if (introMapper.selectByPrimaryKey(intro.getId()) == null) {
                return new ServiceResult(403, Message.intro_not_found);
            }
            if (introMapper.updateByPrimaryKeySelective(intro) != 1) {
                return new ServiceResult(404, Message.database_exception);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200,Message.success,intro);
    }

    /**
     * 负责删除一条信息点
     *
     * @param introId
     * @name removeIntro
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    @Override
    @Permmision(module = Module.intro,operation = Operation.REMOVE)
    public ServiceResult removeIntro(Long introId) {
        if (introId == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Intro intro;
        try {
            intro = introMapper.selectByPrimaryKey(introId);
            if(intro==null){
                return new ServiceResult(401,Message.intro_not_found);
            }
            if(introMapper.deleteByPrimaryKey(introId)!=1){
                return new ServiceResult(402,Message.database_exception);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200,Message.success, intro);
    }

    /**
     * 获取一个信息
     *
     * @param introId
     * @name selectIntro
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult selectIntro(Long introId) {
        if (introId == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Intro intro ;
        try {
            intro = introMapper.selectByPrimaryKey(introId);
            if(intro==null){
                return new ServiceResult(404,Message.intro_not_found);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200,intro);
    }

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
    @Override
    public ServiceResult listIntro(int page, int pageSize) {
        if (page <= 0) {
            return new ServiceResult(400, Message.page_invalid);
        }
        if (pageSize <= 0) {
            return new ServiceResult(400, Message.pageSize_invalid);
        }
        int count;
        List<Intro> introList;
        try {
            PageHelper.startPage(page,pageSize);
            introList = introMapper.listPage();
            count = introMapper.selectCount();
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, new PageVO(PageUtils.getPage(count, pageSize), introList));
    }
    /**
     * 用于校验数据
     *
     * @return
     * @name validate
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-30
     */
    private String validate(Intro intro) {
        if (!ValidationUtils.inMaxVarcharSize(intro.getTitle())) {
            return Message.title_too_long.name();
        }if(!ValidationUtils.inMaxTextSize(intro.getDescription())){
            return Message.description_too_long.name();
        } else {
            return null;
        }
    }

}
