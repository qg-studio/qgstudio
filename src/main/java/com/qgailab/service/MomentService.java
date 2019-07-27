package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Moment;
import org.springframework.stereotype.Service;

@Service
public interface MomentService {

    ServiceResult InsertMoment(Moment moment);

    ServiceResult RemoveMoment(Long id);

    ServiceResult UpdateMoment(Moment moment);

    ServiceResult SelectMoment(Long id);
}
