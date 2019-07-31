package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Feature;
import com.qgailab.model.po.Image;
import com.qgailab.service.FeatureService;
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
 * @date 2019-07-27 09:21
 */
@RestController
@RequestMapping(value = "/feature")
public class FeatureController {

    @Autowired
    private UploadService uploadService;

    /**
     * 负责上传图片
     *
     * @name uploadImage
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult uploadImage(HttpServletRequest request,String description,
                              @RequestParam(value = "featureId") Long featureId, @RequestParam(value = "uploads") MultipartFile[] uploads) {
        if (uploads == null || uploads.length == 0) {
            return new ServiceResult(400, Message.image_not_null);
        }
        Feature feature = null;
        try {
            ServiceResult result = featureService.selectFeature(featureId);
            if (result.getStatus() != 200) {
                return result;
            }
            String path = request.getSession().getServletContext().getRealPath("/upload/");
            feature = (Feature) result.getData();
            //保存图片数组
            List<Image> list = uploadService.uploadImage(feature.getUuid(), uploads, path,description);
            //更新到feature中
            List<Image> oldList = feature.getImages();
            if (oldList == null) {
                feature.setImages(list);
            } else {
                oldList.addAll(list);
            }
            featureService.updateFeature(feature);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, feature);
    }



    @Autowired
    private FeatureService featureService;

    /**
     * @name 插入特色信息
     * @param feature
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ServiceResult insertFeature(@RequestBody Feature feature) {
        return featureService.insertFeature(feature);
    }

    /**
     * @name 删除特色信息
     * @param  featureId
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ServiceResult removeFeature(Long featureId) {
        return featureService.removeFeature(featureId);
    }

    /**
     * @name 更新特色信息
     * @param  feature
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ServiceResult updateFeature(@RequestBody Feature feature) {
        return featureService.updateFeature(feature);
    }

    /**
     * @name 查询特色信息
     * @param  featureId
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/select")
    public ServiceResult selectFeature(Long featureId) {
        return featureService.selectFeature(featureId);
    }

    /**
     * 分页查询首页信息
     *
     * @param page     页数
     * @param pageSize 一页的最大记录数
     * @return
     * @name listFeature
     * @notice none
     * @author <a href="">gp</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET})
    public ServiceResult listFeature(int page, int pageSize) {
        return featureService.listFeature(page, pageSize);
    }

}
