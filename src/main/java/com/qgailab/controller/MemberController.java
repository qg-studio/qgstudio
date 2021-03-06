package com.qgailab.controller;

import com.qgailab.exception.NotImageException;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Image;
import com.qgailab.model.po.Member;
import com.qgailab.service.ImageService;
import com.qgailab.service.MemberService;
import com.qgailab.service.UploadService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author < a href=" ">郭沛</ a>
 * @description
 * @date 2019-07-27 10:02
 */
@RestController
@RequestMapping(value = "/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private ImageService imageService;

    /**
     * 分页查询首页信息
     *
     * @param page     页数
     * @param pageSize 一页的最大记录数
     * @return
     * @name listFeature
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    ServiceResult listMember(int page, int pageSize, String grade, String field) {
        return memberService.listMember(page, pageSize, grade, field);
    }

    /**
     * @param member
     * @return ServiceResult
     * @name 插入成员的信息
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult insertMember(@RequestBody Member member) {
        return memberService.insertMember(member);
    }

    /**
     * @param member
     * @return ServiceResult
     * @name 更新成员的信息
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult updateMember(@RequestBody Member member) {
        return memberService.updateMember(member);
    }

    /**
     * @param memberId
     * @return ServiceResult
     * @name 删除指导老师信息
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/remove")
    public @ResponseBody
    ServiceResult removeMember(Long memberId) {
        return memberService.removeMember(memberId);
    }

    /**
     * @param memberId
     * @return ServiceResult
     * @name 查询单个成员信息
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/select")
    public @ResponseBody
    ServiceResult selectMember(Long memberId) {
        return memberService.selectMember(memberId);
    }

    /**
     * 负责上传成员图片
     *
     * @name uploadImage
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult uploadImage(HttpServletRequest request, @RequestParam(value = "memberId") Long memberId, @RequestParam(value = "uploads") MultipartFile[] uploads) {
        if (uploads == null || uploads.length == 0) {
            return new ServiceResult(400, Message.image_not_null);
        }
        Member member = null;
        try {
            ServiceResult result = memberService.selectMember(memberId);
            if (result.getStatus() != 200) {
                return result;
            }
            String path = request.getSession().getServletContext().getRealPath("/upload/");
            member = (Member) result.getData();
            //保存图片数组
            List<Image> list = uploadService.uploadImage(member.getUuid(), uploads, path);
            //更新到leader中
            List<Image> oldList = member.getImages();
            //删除之前的图片
            imageService.removeImageList(path, oldList);
            member.setImages(list);
            memberService.updateMember(member);
        } catch (NotImageException e) {
            return new ServiceResult(400,Message.image_type_error);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, member);
    }
}
