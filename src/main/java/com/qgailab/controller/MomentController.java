package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Image;
import com.qgailab.model.po.Moment;
import com.qgailab.service.MomentService;
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
 * @date 2019-07-27 10:01
 */
@RestController
@RequestMapping(value = "/moment")
public class MomentController {

    @Autowired
    private MomentService momentService;

    @Autowired
    private UploadService uploadService;
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
    ServiceResult listMoment(int page, int pageSize) {
        return momentService.listMoment(page, pageSize);
    }

    /**
     * @name 插入重要时刻的信息
     * @param moment
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult insertMoment(@RequestBody Moment moment) {
        return momentService.insertMoment(moment);
    }

    /**
     * @name 更新重要时刻的信息
     * @param moment
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult updateMoment(@RequestBody Moment moment) {
        return momentService.updateMoment(moment);
    }

    /**
     * @name 删除重要时刻信息
     * @param momentId
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/remove")
    public @ResponseBody
    ServiceResult removeMoment(Long momentId) {
        return momentService.removeMoment(momentId);
    }

    /**
     * @name 查询单个重要时刻的信息
     * @param momentId
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/select")
    public @ResponseBody
    ServiceResult selectMoment(Long momentId) {
        return momentService.selectMoment(momentId);
    }

    /**
     * 负责上传重要时刻的图片
     * @name uploadImage
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-26
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult uploadImage(HttpServletRequest request,String description,
                              @RequestParam(value = "momentId") Long momentId, @RequestParam(value = "uploads") MultipartFile[] uploads) {
        if (uploads == null || uploads.length == 0) {
            return new ServiceResult(400, Message.image_not_null);
        }
        Moment moment = null;
        try {
            ServiceResult result = momentService.selectMoment(momentId);
            if (result.getStatus() != 200) {
                return result;
            }
            String path = request.getSession().getServletContext().getRealPath("/upload/");
            moment = (Moment) result.getData();
            //保存图片数组
            List<Image> list = uploadService.uploadFile(moment.getUuid(), uploads, path,description);
            //更新到moment中
            List<Image> oldList = moment.getImages();
            if (oldList == null) {
                moment.setImages(list);
            } else {
                oldList.addAll(list);
            }
            momentService.updateMoment(moment);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, moment);
    }
}
