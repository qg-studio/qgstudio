package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.service.ImageService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * 实现图片的上传
 * @program: qgstudio
 * @author: gp
 * @create: 2019-07-26 16:08
 **/
@Controller
@RequestMapping(value = "/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "photoupload")
    public ServiceResult photoupload(MultipartFile upload) throws IOException {
        // 定义上传文件服务器路径
        String path = "http://localhost:9090/uploads/";
        // 说明上传文件项
        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件的名称设置唯一值，uuid
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        // 创建客户端的对象
        Client client = Client.create();
        // 和图片服务器进行连接
        WebResource webResource = client.resource(path + filename);
        // 上传文件
        webResource.put(upload.getBytes());

    }


}
