package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Member;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {

    ServiceResult insertMember(Member member);

    ServiceResult removeMember(Long id);

    ServiceResult selectMember(Long id);

    ServiceResult updateMember(Member member);

    /**
     * 返回信息点
     *
     * @param page  页数
     * @param pageSize 一页最大记录数
     * @name listMember
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult listMember(int page, int pageSize);
}
