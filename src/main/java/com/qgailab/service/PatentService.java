package com.qgailab.service;

import com.qgailab.model.po.Patent;

import java.math.BigInteger;

public interface PatentService {

    /**
    * 插入专利信息
    * @Param: patent
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    public String InsertPatent(Patent patent);

    /**
    * 删除专利信息
    * @Param: [id]
    * @return: java.lang.String
    * @Author: gp
    * @Date: 2019/7/26
    */
    public String DeletePatent(Long id);

    /**
     * 负责更新专利信息
    * @Param: [patent]
    * @return: java.lang.String
    * @Author: gp
    * @Date: 2019/7/26
    */
    public String UpdatePatent(Patent patent);

    /**
     * 负责查询专利信息
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    public String SelectParent(Long id);

}
