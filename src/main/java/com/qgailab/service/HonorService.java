package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Honor;
import org.springframework.stereotype.Service;

@Service
public interface HonorService {

    /**
     * @name insertHonor
     * @param  honor
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult insertHonor(Honor honor);

    /**
     * @name selectHonor
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult selectHonor(Long id);

    /**
     * @name RemoveHonor
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult removeHonor(Long id);

    /**
     * @name UpdateHonor
     * @param  honor
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult updateHonor(Honor honor);

}
