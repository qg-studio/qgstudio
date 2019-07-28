package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.dao.AwardMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Award;
import com.qgailab.service.AwardService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 奖项的CURD
 * @program: qgstudio
 * @author: gp
 * @create: 2019-07-26 09:24
 **/
@Service()
public class AwardServiceImpl implements AwardService {

    @Autowired
    private AwardMapper awardMapper;

    /**
     * 负责查询一条奖项信息
     *
     * @param id
     * @name selectAward
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult selectAward(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Award award;
        try {
            award = awardMapper.selectByPrimaryKey(id);
            if (award == null) {
                return new ServiceResult(401, Message.award_not_found);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }

        return new ServiceResult(200, Message.success, award);
    }

    /**
     * 负责删除一条奖项信息
     *
     * @param id
     * @name removeAward
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult removeAward(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Award award;
        try {
            award = awardMapper.selectByPrimaryKey(id);
            if (award == null) {
                return new ServiceResult(401, Message.award_not_found);
            }
            if (awardMapper.deleteByPrimaryKey(id) != 1) {
                return new ServiceResult(402,Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success, award);
    }

    /**
     * 负责插入一条奖项信息
     *
     * @param award
     * @name insertAward
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult insertAward(Award award) {
        if (award == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (awardMapper.insertSelective(award) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success,award);
    }

    /**
     * 负责更新一条奖项信息
     *
     * @param award
     * @name updateAward
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult updateAward(Award award) {

        if (award == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (award.getId() == null) {
                return new ServiceResult(400, Message.parameter_not_enough);
            }
            if (awardMapper.selectByPrimaryKey(award.getId()) == null) {
                return new ServiceResult(401, Message.award_not_found);
            }
            if (award.getProject() == null || award.getProject().trim().isEmpty()) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            if (award.getGame() == null || award.getGame().trim().isEmpty()) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            if (award.getPrize() == null || award.getPrize().trim().isEmpty()) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            if (awardMapper.updateByPrimaryKeySelective(award) != 1) {
                return new ServiceResult(402,Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, award);
    }

    /**
     * 负责查询专利信息
     * @param page  页数
     * @param pageSize 一页最大记录数
     * @return: ServiceResult
     * @Author: gp
     * @Date: 2019/7/26
     */
    @Override
    public ServiceResult listAward(int page, int pageSize) {
        if (page < 0 ){
            return new ServiceResult(400, Message.page_invalid);
        }
        List<Award> awardList;
        try {
            PageHelper.startPage(page, pageSize);
            awardList = awardMapper.listPage(page * pageSize, pageSize);
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, awardList);
    }
}
