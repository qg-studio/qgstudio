package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Feature;
import com.qgailab.model.po.Field;
import org.springframework.stereotype.Service;

@Service
public interface FieldService {

    /**
     * 插入领域
     * @name InsertField
     * @param  field
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult insertField(Field field);

    /**
     * 删除领域
     * @name RemoveField
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult removeField(Long id);

    /**
     * 查询领域
     * @name SelectField
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult selectField(Long id);

    /**
     * 更新领域
     * @name UpdateField
     * @param  field
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult updateField(Field field);

    /**
     * 返回信息点
     *
     * @param page  页数
     * @param pageSize 一页最大记录数
     * @name listField
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult listField(int page, int pageSize);

}
