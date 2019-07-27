package com.qgailab.service.impl;

import com.qgailab.dao.LeaderMapper;
import com.qgailab.dao.MemberMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Member;
import com.qgailab.service.MemberService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 成员增删查改
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-26 22:23
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;
    @Override
    public ServiceResult insertMember(Member member) {
        try {
            if (member == null || member.getName() == null || member.getName().trim().isEmpty()) {
                return new ServiceResult(400, Message.parameter_not_enough);
            }
            if (memberMapper.insertSelective(member) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, member);

    }

    @Override
    public ServiceResult RemoveMember(Long id) {
        Member member = memberMapper.selectByPrimaryKey(id);
        try {
            if (member == null) {
                return new ServiceResult(401, Message.member_not_found);
            }
            if (memberMapper.deleteByPrimaryKey(id) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success);
    }

    @Override
    public ServiceResult SelectMember(Long id) {
        Member member = memberMapper.selectByPrimaryKey(id);
        try {
            if (member == null) {
                return new ServiceResult(401, Message.member_not_found);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, member);
    }

    @Override
    public ServiceResult UpdateMember(Member member) {
        try {
            if (member == null || member.getName() == null || member.getName().trim().isEmpty()) {
                return new ServiceResult(400, Message.parameter_not_enough);
            }
            if (memberMapper.updateByPrimaryKeySelective(member) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, member);
    }
}
