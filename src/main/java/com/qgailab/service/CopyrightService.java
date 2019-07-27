package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Copyright;
import org.springframework.stereotype.Service;

@Service
public interface CopyrightService {

    /**增加著作权
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult InsertCopyright(Copyright copyright);

    /**删除某列著作权
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult RemoveCopyright(Long id);

    /**更新著作权信息
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult UpdateCopyright(Copyright copyright);

    /**查询某一著作权
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult SelectCopyright(Long id);
}
