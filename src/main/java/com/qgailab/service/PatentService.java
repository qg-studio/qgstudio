package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Patent;

public interface PatentService {

    /**
    * 插入专利信息
    * @Param: patent
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult InsertPatent(Patent patent);

    /**
    * 删除专利信息
    * @Param: [id]
    * @return: java.lang.String
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult DeletePatent(Long id);

    /**
     * 负责更新专利信息
    * @Param: [patent]
    * @return: java.lang.String
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult UpdatePatent(Patent patent);

    /**
     * 负责查询专利信息
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult SelectParent(Long id);

}