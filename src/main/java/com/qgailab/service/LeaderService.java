package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Leader;
import com.qgailab.model.po.Patent;
import org.springframework.stereotype.Service;

@Service
public interface LeaderService {

    /**
     * @name InsertLeader
     * @param  leader
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult insertLeader(Leader leader);

    /**
     * @name InsertLeader
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult deleteLeader(Long id);

    /**
     * @name InsertLeader
     * @param  leader
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult updateLeader(Leader leader);

    /**
     * @name InsertLeader
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult selectLeader(Long id);
}
