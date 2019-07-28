package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.dao.PatentMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Intro;
import com.qgailab.model.po.Patent;
import com.qgailab.service.PatentService;
import com.qgailab.service.constants.Message;
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
     *负责插入专利
     * @Param: [patent]
     * @return: java.lang.String
     * @Author: gp
     * @Date: 2019/7/26
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
     * 负责删除专利信息
    * @Param: [id]
    * @return: java.lang.String
    * @Author: gp
    * @Date: 2019/7/26
    */
    @Override
    public ServiceResult removePatent(Long id) {

        Patent patent ;
        try {
            patent = patentMapper.selectByPrimaryKey(id);
            if (patent == null) {
                return new ServiceResult(401,Message.patent_not_found);
            }
            patentMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200,Message.success, patent);
    }

    /**
     * 负责更新专利信息
    * @Param: [patent]
    * @return: java.lang.String
    * @Author: gp
    * @Date: 2019/7/26
    */
    @Override
    public ServiceResult updatePatent(Patent patent) {

        if (patent == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            //专利名不能为空
            if (patent.getName() == null || patent.getName().trim().isEmpty()) {
                return new ServiceResult(401, Message.name_not_null);
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
     * 负责查询专利信息
    * @Param: [id]
    * @return: java.lang.String
     *w
    * @Author: gp
    * @Date: 2019/7/26
    */
    @Override
    public ServiceResult selectParent(Long id) {

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
        if (page < 0) {
            return new ServiceResult(400, Message.page_invalid);
        }
        List<Patent> patentList;
        try {
            PageHelper.startPage(page, pageSize);
            patentList = patentMapper.listPage(page * pageSize, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, patentList);
    }
}



