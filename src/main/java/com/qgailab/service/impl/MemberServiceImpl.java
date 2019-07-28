package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.dao.LeaderMapper;
import com.qgailab.dao.MemberMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Member;
import com.qgailab.model.po.Moment;
import com.qgailab.service.MemberService;
import com.qgailab.service.constants.Message;
import com.qgailab.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 成员增删查改
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-26 22:23
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    /**
     * 负责插入一条成员信息
     *
     * @param member
     * @name insertMember
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult insertMember(Member member) {
        if (member == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (member.getName() == null || member.getName().trim().isEmpty()) {
                return new ServiceResult(401, Message.name_not_null);
            }
            member.setUuid(UUIDUtils.getUUID());
            if (memberMapper.insertSelective(member) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, member);

    }

    /**
     * 负责删除一条成员信息
     *
     * @param id
     * @name removeMember
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult removeMember(Long id) {
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
        return new ServiceResult(200, Message.success, member);
    }

    /**
     * 负责查询一条成员信息
     *
     * @param id
     * @name selectMember
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult selectMember(Long id) {
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

    /**
     * 负责更新一条成员信息
     *
     * @param member
     * @name updateMember
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult updateMember(Member member) {
        if (member == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (member.getName() == null || member.getName().trim().isEmpty()) {
                return new ServiceResult(401, Message.name_not_null);
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

    /**
     * 负责查询多个成员信息
     * @param page  页数
     * @param pageSize 一页最大记录数
     * @return: ServiceResult
     * @Author: gp
     * @Date: 2019/7/26
     */
    @Override
    public ServiceResult listMember(int page, int pageSize) {
        if (page < 0 ){
            return new ServiceResult(400, Message.page_invalid);
        }
        List<Member> memberList;
        try {
            PageHelper.startPage(page, pageSize);
            memberList = memberMapper.listPage(page * pageSize, pageSize);
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, memberList);
    }


}
