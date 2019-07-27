package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Feature;
import com.qgailab.model.po.Field;
import org.springframework.stereotype.Service;

@Service
public interface FieldService {

    /**
     * @name InsertField
     * @param  field
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult InsertField(Field field);

    /**
     * @name RemoveField
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult RemoveField(Long id);

    /**
     * @name SelectField
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult SelectField(Long id);

    /**
     * @name UpdateField
     * @param  field
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult UpdateField(Field field);



}
