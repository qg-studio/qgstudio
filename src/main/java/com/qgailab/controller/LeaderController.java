package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Image;
import com.qgailab.model.po.Leader;
import com.qgailab.service.LeaderService;
import com.qgailab.service.UploadService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 10:02
 */
@RestController
@RequestMapping(value = "/leader")
public class LeaderController {

    @Autowired
    private LeaderService leaderService;

    @Autowired
    private UploadService uploadService;

    /**
     * @name 插入指导老师信息
     * @param leader
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult insertLeader(@RequestBody Leader leader) {
        return leaderService.insertLeader(leader);
    }

    /**
     * @name 更新指导老师信息
     * @param leader
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult updateLeader(@RequestBody Leader leader) {
        return leaderService.updateLeader(leader);
    }

    /**
     * @name 删除指导老师信息
     * @param leaderId
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/remove")
    public @ResponseBody
    ServiceResult removeLeader(Long leaderId) {
        return leaderService.deleteLeader(leaderId);
    }

    /**
     * @name 查询指导老师信息
     * @param leaderId
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/select")
    public @ResponseBody
    ServiceResult selectLeader(Long leaderId) {
        return leaderService.selectLeader(leaderId);
    }

    /**
     * 负责上传图片
     *
     * @name uploadImage
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult uploadImage(HttpServletRequest request, @RequestParam(value = "leaderId") Long leaderId, @RequestParam(value = "uploads") MultipartFile[] uploads) {
        if (uploads == null || uploads.length == 0) {
            return new ServiceResult(400, Message.image_not_null);
        }
        Leader leader = null;
        try {
            ServiceResult result = leaderService.selectLeader(leaderId);
            if (result.getStatus() != 200) {
                return result;
            }
            String path = request.getSession().getServletContext().getRealPath("/upload/");
            leader = (Leader) result.getData();
            //保存图片数组
            List<Image> list = uploadService.uploadFile(leader.getUuid(), uploads, path);
            //更新到leader中
            List<Image> oldList = leader.getImages();
            if (oldList == null) {
                leader.setImages(list);
            } else {
                oldList.addAll(list);
            }
            leaderService.updateLeader(leader);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, leader);
    }

    /**
     * 分页查询指导老师信息
     *
     * @param page     页数
     * @param pageSize 一页的最大记录数
     * @return
     * @name listLeader
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    ServiceResult listLeader(int page, int pageSize) {
        return leaderService.listLeader(page, pageSize);
    }
}