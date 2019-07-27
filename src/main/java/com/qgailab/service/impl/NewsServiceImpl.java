package com.qgailab.service.impl;

import com.qgailab.dao.NewsMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.News;
import com.qgailab.service.NewsService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 新闻专栏增删查改
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 00:03
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;
    @Override
    public ServiceResult InsertNews(News news) {
        if (news == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (news.getTitle() == null || news.getTitle().trim().isEmpty()) {
                return new ServiceResult(400, Message.parameter_not_enough);
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

    @Override
    public ServiceResult RemoveNews(Long id) {
        News news;
        try {
            news = newsMapper.selectByPrimaryKey(id);
            if (news == null) {
                return new ServiceResult(401,Message.news_not_found);
            }
            newsMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200,Message.success);
    }

    @Override
    public ServiceResult UpdateNews(News news) {
        if (news == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (news.getTitle() == null || news.getTitle().trim().isEmpty()) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            if (news.getUrl() == null || news.getUrl().trim().isEmpty()) {
                return new ServiceResult(401, Message.parameter_not_enough);
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

    @Override
    public ServiceResult SelectNews(Long id) {
        News news = null;
        try {
            news = newsMapper.selectByPrimaryKey(id);
            if (news == null) {
                return new ServiceResult(401, Message.news_not_found);
            }
            return new ServiceResult(200, Message.success, news);
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
    }
}
