package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping(value = "/remove")
    public ServiceResult photoupload(HttpServletRequest request,Long imageId) {
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        return imageService.removeImage(path,imageId);
    }
}
