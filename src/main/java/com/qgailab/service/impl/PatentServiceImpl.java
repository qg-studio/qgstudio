package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.dao.PatentMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Intro;
import com.qgailab.model.po.PageVO;
import com.qgailab.model.po.Patent;
import com.qgailab.service.PatentService;
import com.qgailab.service.constants.Message;
import com.qgailab.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 紫金大佬
 */
@Service
public class PatentServiceImpl implements PatentService {

    @Autowired
    private PatentMapper patentMapper;

    /**
     * 负责插入一条专利信息
     *
     * @param patent
     * @name insertPatent
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult insertPatent(Patent patent) {

        if (patent == null ) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (patent.getName() == null || patent.getName().trim().isEmpty()) {
                return new ServiceResult(401, Message.name_not_null);
            }

            if (patentMapper.insertSelective(patent) !=1) {
                return new ServiceResult(402, Message.database_exception);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success,patent);
    }


    /**
     * 负责删除一条专利
     *
     * @param id
     * @name removePatent
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult removePatent(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Patent patent ;
        try {
            patent = patentMapper.selectByPrimaryKey(id);
            if (patent == null) {
                return new ServiceResult(401,Message.patent_not_found);
            }
            if (patentMapper.deleteByPrimaryKey(id) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200,Message.success, patent);
    }

    /**
     * 负责更新一条专利信息
     *
     * @param patent
     * @name updatePatent
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult updatePatent(Patent patent) {

        if (patent == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (patent.getId() == null) {
                return new ServiceResult(400, Message.parameter_not_enough);
            }
            //专利名不能为空
            if (patent.getName() == null || patent.getName().trim().isEmpty()) {
                return new ServiceResult(401, Message.name_not_null);
            }
            if (patentMapper.selectByPrimaryKey(patent.getId()) == null) {
                return new ServiceResult(401, Message.patent_not_found);
            }
            if (patentMapper.updateByPrimaryKeySelective(patent) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success,patent);
    }

    /**
     * 负责查询一条专利信息
     *
     * @param id
     * @name selectParent
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult selectParent(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Patent patent = null;
        try {
            patent = patentMapper.selectByPrimaryKey(id);
            if (patent == null) {
                return new ServiceResult(401, Message.patent_not_found);
            }
            return new ServiceResult(200, Message.success, patent);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ServiceResult(200, Message.success, patent);
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
    public ServiceResult listPatent(int page, int pageSize) {
        if (page <= 0) {
            return new ServiceResult(400, Message.page_invalid);
        }
        if (pageSize <= 0) {
            return new ServiceResult(401, Message.pageSize_invalid);
        }
        List<Patent> patentList;
        int count;
        try {
            PageHelper.startPage(page, pageSize);
            patentList = patentMapper.listPage();
            count = patentMapper.selectCount();
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, new PageVO(PageUtils.getPage(count, pageSize), patentList));
    }
}



