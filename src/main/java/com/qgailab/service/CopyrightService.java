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
    ServiceResult insertCopyright(Copyright copyright);

    /**删除某列著作权
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult removeCopyright(Long id);

    /**更新著作权信息
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult updateCopyright(Copyright copyright);

    /**查询某一著作权
    * @Param:
    * @return:
    * @Author: gp
    * @Date: 2019/7/26
    */
    ServiceResult selectCopyright(Long id);

    /**
     * 返回信息点
     *
     * @param page  页数
     * @param pageSize 一页最大记录数
     * @name listCopyright
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult listCopyright(int page, int pageSize);
}
