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
}
