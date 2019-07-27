package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Award;
import org.springframework.stereotype.Service;

@Service
public interface AwardService {

    /**
     * 负责查询奖项的信息
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult selectAward(Long id);

    /**
     * 负责删除奖项的信息
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult removeAward(Long id);

    /**
     * 负责添加奖项的信息
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult insertAward(Award award);

    /**负责更新奖项的信息
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult updateAward(Award award);



}
