package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Patent;
import org.springframework.stereotype.Service;

@Service
public interface PatentService {

    /**
    * 插入专利信息
    * @Param: patent
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult insertPatent(Patent patent);

    /**
    * 删除专利信息
    * @Param: [id]
    * @return: java.lang.String
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult removePatent(Long id);

    /**
     * 负责更新专利信息
    * @Param: [patent]
    * @return: java.lang.String
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult updatePatent(Patent patent);

    /**
     * 负责查询专利信息
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult selectParent(Long id);

    /**
     * 返回信息点
     *
     * @param page  页数
     * @param pageSize 一页最大记录数
     * @name listPatent
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult listPatent(int page, int pageSize);

}
