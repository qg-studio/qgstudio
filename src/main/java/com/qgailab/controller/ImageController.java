package com.qgailab.controller;

import com.qgailab.dao.ImageMapper;
import com.qgailab.exception.NotImageException;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Image;
import com.qgailab.service.ImageService;
import com.qgailab.service.UploadService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 实现图片的上传
 *
 * @program: qgstudio
 * @author: gp
 * @create: 2019-07-26 16:08
 **/
@RestController
@RequestMapping(value = "/image")
public class ImageController {

    @Autowired
    private ImageService imageService;
    @Autowired
    private ImageMapper imageMapper;
    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "/remove")
    public ServiceResult removeImage(HttpServletRequest request, Long imageId) {
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        return imageService.removeImage(path, imageId);
    }

    @RequestMapping(value = "/update")
    public ServiceResult updateImage(@RequestBody Image image) {
        return imageService.updateImage(image);
    }


    @RequestMapping(value = "/replace")
    public ServiceResult replaceImage(HttpServletRequest request, @RequestParam(value = "imageId") Long imageId, @RequestParam(value = "uploads") MultipartFile[] uploads) {
        if (uploads == null || uploads.length == 0) {
            return new ServiceResult(400, Message.image_not_null);
        }
        ServiceResult result;
        MultipartFile upload = uploads[0];
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        try {
           result=  imageService.updateImage(upload, path, imageId);
        } catch (NotImageException e) {
            e.printStackTrace();
            return new ServiceResult(402,Message.type_not_support);
        }
        return result;
    }


}
