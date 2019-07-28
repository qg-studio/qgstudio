package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.dao.NewsMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.News;
import com.qgailab.service.NewsService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 新闻专栏增删查改
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 00:03
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    /**
     * 负责插入一条新闻信息
     *
     * @param news
     * @name insertNews
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult insertNews(News news) {
        if (news == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (news.getTitle() == null || news.getTitle().trim().isEmpty()) {
                return new ServiceResult(400, Message.title_not_null);
            }
            if (newsMapper.insertSelective(news) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success,news);
    }

    /**
     * 负责删除一条新闻信息
     *
     * @param id
     * @name removeNews
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult removeNews(Long id) {
        News news;
        try {
            news = newsMapper.selectByPrimaryKey(id);
            if (news == null) {
                return new ServiceResult(401,Message.news_not_found);
            }
            if (newsMapper.deleteByPrimaryKey(id) != 1) {
                return new ServiceResult(402,Message.database_exception);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200,Message.success,news);
    }

    /**
     * 负责更新一条新闻信息
     *
     * @param news
     * @name updateNews
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult updateNews(News news) {
        if (news == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (news.getTitle() == null || news.getTitle().trim().isEmpty()) {
                return new ServiceResult(401, Message.title_not_null);
            }
            if (news.getUrl() == null || news.getUrl().trim().isEmpty()) {
                return new ServiceResult(401, Message.url_not_null);
            }
            if (newsMapper.updateByPrimaryKeySelective(news) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success,news);
    }

    /**
     * 负责查询一条新闻信息
     *
     * @param id
     * @name selectNews
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult selectNews(Long id) {
        News news = null;
        try {
            news = newsMapper.selectByPrimaryKey(id);
            if (news == null) {
                return new ServiceResult(401, Message.news_not_found);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
            return new ServiceResult(200, Message.success, news);
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
    public ServiceResult listNews(int page, int pageSize) {
        if (page < 0 ){
            return new ServiceResult(400, Message.page_invalid);
        }
        List<News> newsList;
        try {
            PageHelper.startPage(page, pageSize);
            newsList = newsMapper.listPage(page * pageSize, pageSize);
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, newsList);
    }
}
