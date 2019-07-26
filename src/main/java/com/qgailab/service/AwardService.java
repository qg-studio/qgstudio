package com.qgailab.service;

import com.qgailab.model.po.Award;

public interface AwardService {

    /**
     * 负责查询奖项的信息
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    public String SelectAward(Long id);

    /**
     * 负责删除奖项的信息
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    public String RemoveAward(Long id);

    /**
     * 负责添加奖项的信息
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    public String InsertAward(Award award);

    /**负责更新奖项的信息
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    public String UpdateAward(Award award);



}
