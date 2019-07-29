package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.dao.ImageMapper;
import com.qgailab.dao.MemberMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Image;
import com.qgailab.model.po.Member;
import com.qgailab.model.po.PageVO;
import com.qgailab.service.MemberService;
import com.qgailab.service.constants.Message;
import com.qgailab.util.PageUtils;
import com.qgailab.util.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author < a href=" ">郭沛</ a>
 * @description 成员增删查改
 * @date 2019-07-26 22:23
 */
@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private ImageMapper imageMapper;

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
            //没有图片的插入默认图片
            if (member.getImages() == null || member.getImages().size() == 0) {
                Image image = new Image();
                image.setFilename(imagePath);
                image.setFilename(member.getUuid());
                imageMapper.insertSelective(image);
            }

            if (memberMapper.insertSelective(member) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        } catch (Exception e) {
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
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Member member;
        try {
            member = memberMapper.selectByPrimaryKey(id);
            if (member == null) {
                return new ServiceResult(401, Message.member_not_found);
            }
            if (memberMapper.deleteByPrimaryKey(id) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        } catch (Exception e) {
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
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Member member;
        try {
            member = memberMapper.selectByPrimaryKey(id);
            if (member == null) {
                return new ServiceResult(401, Message.member_not_found);
            }
        } catch (Exception e) {
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
            if (member.getId() == null) {
                return new ServiceResult(400, Message.parameter_not_enough);
            }
            if (member.getName() == null || member.getName().trim().isEmpty()) {
                return new ServiceResult(401, Message.name_not_null);
            }
            if(memberMapper.selectByPrimaryKey(member.getId())==null){
                return new ServiceResult(402,Message.member_not_found);
            }
            if (memberMapper.updateByPrimaryKeySelective(member) != 1) {
                return new ServiceResult(403, Message.database_exception);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, member);
    }

    @Value(value = "#{conf.image}")
    private String imagePath;

    /**
     * 负责查询多个成员信息
     *
     * @param page     页数
     * @param pageSize 一页最大记录数
     * @return: ServiceResult
     * @Author: gp
     * @Date: 2019/7/26
     */
    @Override
    public ServiceResult listMember(int page, int pageSize,String grade,String field) {
        if (page <= 0) {
            return new ServiceResult(400, Message.page_invalid);
        }
        if (pageSize <= 0) {
            return new ServiceResult(401, Message.pageSize_invalid);
        }
        if(grade==null||grade.trim().isEmpty()||grade.equalsIgnoreCase("")||grade.equalsIgnoreCase("null")){
            grade=null;
        }
        if(field==null||field.trim().isEmpty()||field.equalsIgnoreCase("")||field.equalsIgnoreCase("null")){
            field=null;
        }
        List<Member> memberList;
        int count;
        try {
            PageHelper.startPage(page, pageSize);
            memberList = memberMapper.listPageSelective(grade,field);
            count = memberMapper.selectCountSelective(grade,field);
            //创建一个默认的成员
            Member member = new Member();
            member.setField("");
            member.setName("");
            member.setGrade("");
            Image image = new Image();
            image.setFilename(imagePath);
            List<Image> imageList = new LinkedList<>();
            imageList.add(image);
            member.setImages(imageList);
            memberList.add(member);

        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, new PageVO(PageUtils.getPage(count, pageSize), memberList));
    }
}
