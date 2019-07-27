package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Moment;
import org.springframework.stereotype.Service;

@Service
public interface MomentService {

    ServiceResult insertMoment(Moment moment);

    ServiceResult removeMoment(Long id);

    ServiceResult updateMoment(Moment moment);

    ServiceResult selectMoment(Long id);
}
