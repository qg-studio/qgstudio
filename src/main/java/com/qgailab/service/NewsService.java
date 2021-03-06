package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.News;
import org.springframework.stereotype.Service;

@Service
public interface NewsService {

    /**
     * 插入新闻信息
     * @Param: patent
     * @return:
     * @Author: gp
     * @Date: 2019/7/26
     */
    ServiceResult insertNews(News news);

    /**
     * 删除新闻信息
     * @Param: [id]
     * @return: java.lang.String
     * @Author: gp
     * @Date: 2019/7/26
     */
    ServiceResult removeNews(Long id);

    /**
     * 负责更新新闻信息
     * @Param: [patent]
     * @return: java.lang.String
     * @Author: gp
     * @Date: 2019/7/26
     */
    ServiceResult updateNews(News news);

    /**
     * 负责查询新闻信息
     * @Param:
     * @return:
     * @Author: gp
     * @Date: 2019/7/26
     */
    ServiceResult selectNews(Long id);

    /**
     * 返回信息点
     *
     * @param page  页数
     * @param pageSize 一页最大记录数
     * @name listNews
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult listNews(int page, int pageSize);
}
