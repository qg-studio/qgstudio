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

    /**
     * 返回信息点
     *
     * @param page  页数
     * @param pageSize 一页最大记录数
     * @name listMoment
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult listMoment(int page, int pageSize);
}
