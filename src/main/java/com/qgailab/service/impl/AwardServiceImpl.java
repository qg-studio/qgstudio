package com.qgailab.service.impl;

import com.qgailab.dao.AwardMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Award;
import com.qgailab.service.AwardService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 奖项的CURD
 * @program: qgstudio
 * @author: gp
 * @create: 2019-07-26 09:24
 **/
@Service
public class AwardServiceImpl implements AwardService {

    @Autowired
    private AwardMapper awardMapper;

    /**
     * 查询奖项
    * @Param: [id]
    * @return: com.qgailab.model.dto.ServiceResult
    * @Author: gp
    * @Date: 2019/7/26
    */
    @Override
    public ServiceResult SelectAward(Long id) {

        Award award = awardMapper.selectByPrimaryKey(id);
        try {
            if (award == null) {
                return new ServiceResult(401, Message.patent_not_found);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }

        return new ServiceResult(200, Message.success, award);
    }

    /**
     * 移除奖项
     * @Param: [id]
     * @return: com.qgailab.model.dto.ServiceResult
     * @Author: gp
     * @Date: 2019/7/26
     */
    @Override
    public ServiceResult RemoveAward(Long id) {

        Award award ;
        try {
            award = awardMapper.selectByPrimaryKey(id);
            if (award == null) {
                return new ServiceResult(401, Message.patent_not_found);
            }
            awardMapper.deleteByPrimaryKey(id);

        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }

        return new ServiceResult(200, Message.success);

    }

    /**
     * 添加奖项
     * @Param: [id]
     * @return: com.qgailab.model.dto.ServiceResult
     * @Author: gp
     * @Date: 2019/7/26
     */
    @Override
    public ServiceResult InsertAward(Award award) {
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
     * 更新奖项
     * @Param: [id]
     * @return: com.qgailab.model.dto.ServiceResult
     * @Author: gp
     * @Date: 2019/7/26
     */
    @Override
    public ServiceResult UpdateAward(Award award) {

        if (award == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (award.getProject() == null || award.getProject().trim().isEmpty()) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            if (award.getGame() == null || award.getGame().trim().isEmpty()) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            if (award.getPrize() == null || award.getPrize().trim().isEmpty()) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            if (awardMapper.updateByPrimaryKey(award) != 1) {
                return new ServiceResult(402,Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, award);
    }
}
