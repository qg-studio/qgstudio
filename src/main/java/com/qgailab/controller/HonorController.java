package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Honor;
import com.qgailab.model.po.Image;
import com.qgailab.service.HonorService;
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
 * @date 2019-07-27 10:03
 */
@RestController
@RequestMapping(value = "/honor")
public class HonorController {

    @Autowired
    private HonorService honorService;
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
    ServiceResult uploadImage(HttpServletRequest request, @RequestParam(value = "honorId") Long honorId, @RequestParam(value = "uploads") MultipartFile[] uploads) {
        if (uploads == null || uploads.length == 0) {
            return new ServiceResult(400, Message.image_not_null);
        }
        Honor honor = null;
        try {
            ServiceResult result = honorService.selectHonor(honorId);
            if (result.getStatus() != 200) {
                return result;
            }
            String path = request.getSession().getServletContext().getRealPath("/upload/");
            honor = (Honor) result.getData();
            //保存图片数组
            List<Image> list = uploadService.uploadImage(honor.getUuid(), uploads, path);
            //更新到honor中
            List<Image> oldList = honor.getImages();
            if (oldList == null) {
                honor.setImages(list);
            } else {
                oldList.addAll(list);
            }
            honorService.updateHonor(honor);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, honor);
    }


    /**
     * 插入最近的荣誉
     *
     * @name insertHonor
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ServiceResult insertHonor(@RequestBody Honor honor) {
        return honorService.insertHonor(honor);
    }


    /**
     * 更新最近的荣誉
     *
     * @name updateHonor
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ServiceResult updateHonor(@RequestBody Honor honor) {
        return honorService.updateHonor(honor);
    }


    /**
     * 删除最近的荣誉
     *
     * @name removeHonor
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ServiceResult removeHonor(Long honorId) {
        return honorService.removeHonor(honorId);
    }


    /**
     * 分页查询最近的荣誉
     *
     * @param page     页数
     * @param pageSize 一页的最大记录数
     * @return
     * @name listHonor
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    ServiceResult listHonor(int page, int pageSize) {
        return honorService.listHonor(page, pageSize);
    }
}
