package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.History;
import org.springframework.stereotype.Service;

@Service
public interface HistoryService {

    /**
     * @name InsertField
     * @param  history
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult insertHistory(History history);

    /**
     * @name InsertField
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult RemoveHistory(Long id);

    /**
     * @name InsertField
     * @param  history
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult UpdateHistory(History history);

    /**
     * @name InsertField
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult SelectHistory(Long id);

}
