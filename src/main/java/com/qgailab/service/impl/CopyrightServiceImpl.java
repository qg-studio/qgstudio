package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.dao.CopyrightMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Copyright;
import com.qgailab.service.CopyrightService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 著作权的增删查改
 * @program: qgstudio
 * @author: gp
 * @create: 2019-07-26 15:11
 **/
@Service
public class CopyrightServiceImpl implements CopyrightService {

    @Autowired
    private CopyrightMapper copyrightMapper;

    /**
     * 负责查询一条指导老师信息
     *
     * @param copyright
     * @name insertCopyright
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult insertCopyright(Copyright copyright) {
        if (copyright == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (copyright.getName() == null || copyright.getName().trim().isEmpty()) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            if (copyright.getRn() == null || copyright.getRn().trim().isEmpty()) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            copyrightMapper.insert(copyright);
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, copyright);
    }

    /**
     * 负责查询一条指导老师信息
     *
     * @param id
     * @name removeCopyright
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult removeCopyright(Long id) {
        Copyright copyright;
        try {
            //查找不到相关的信息
            copyright = copyrightMapper.selectByPrimaryKey(id);
            if (copyright == null) {
                return new ServiceResult(400, Message.copyright_not_found);
            }
            if (copyrightMapper.deleteByPrimaryKey(id) != 1) {
                return new ServiceResult(402, Message.please_retry);
            }
        }catch (Exception e) {
            return new ServiceResult(500, Message.database_exception);
        }
        return new ServiceResult(200, Message.success,copyright);
    }

    /**
     * 负责更新一条著作权信息
     *
     * @param copyright
     * @name updateCopyright
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult updateCopyright(Copyright copyright) {
        try {
            if (copyright == null || copyright.getRn() == null || copyright.getRn().trim().isEmpty()) {
                return new ServiceResult(400, Message.parameter_not_enough);
            }
            if (copyrightMapper.updateByPrimaryKeySelective(copyright) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, copyright);
    }

    /**
     * 负责查询一条著作权信息
     *
     * @param id
     * @name selectCopyright
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult selectCopyright(Long id) {
        //查找不到相关的信息
        Copyright copyright = copyrightMapper.selectByPrimaryKey(id);
        try {
            if (copyright == null) {
                return new ServiceResult(400, Message.copyright_not_found);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.database_exception);
        }
        return new ServiceResult(200, Message.success, copyright);
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
    public ServiceResult listCopyright(int page, int pageSize) {
        if (page < 0 ){
            return new ServiceResult(400, Message.page_invalid);
        }
        List<Copyright> copyrightList;
        try {
            PageHelper.startPage(page, pageSize);
            copyrightList = copyrightMapper.listPage(page * pageSize, pageSize);
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, copyrightList);
    }
}
