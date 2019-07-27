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
    ServiceResult InsertNews(News news);

    /**
     * 删除新闻信息
     * @Param: [id]
     * @return: java.lang.String
     * @Author: gp
     * @Date: 2019/7/26
     */
    ServiceResult RemoveNews(Long id);

    /**
     * 负责更新新闻信息
     * @Param: [patent]
     * @return: java.lang.String
     * @Author: gp
     * @Date: 2019/7/26
     */
    ServiceResult UpdateNews(News news);

    /**
     * 负责查询新闻信息
     * @Param:
     * @return:
     * @Author: gp
     * @Date: 2019/7/26
     */
    ServiceResult SelectNews(Long id);

}
