package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Image;
import com.qgailab.model.po.Intro;
import com.qgailab.service.IntroService;
import com.qgailab.service.UploadService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-26 12:15
 */
@Controller
@RequestMapping(value = "/intro")
public class IntroController {
    @Autowired
    private IntroService introService;

    @Autowired
    private UploadService uploadService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult insertIntro(@RequestBody Intro intro) {
        return introService.insertIntro(intro);
    }

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
    ServiceResult uploadImage(HttpServletRequest request, @RequestParam(value = "introId") Long introId, @RequestParam(value = "uploads") MultipartFile[] uploads) {
        if (uploads == null || uploads.length == 0) {
            return new ServiceResult(400, Message.image_not_null);
        }
        Intro intro = null;
        try {
            ServiceResult result = introService.selectIntro(introId);
            if (result.getStatus() != 200) {
                return result;
            }
            String path = request.getSession().getServletContext().getRealPath("/upload/");
            intro = (Intro) result.getData();
            //保存图片数组
            List<Image> list = uploadService.uploadFile(intro.getUuid(), uploads, path);
            //更新到intro中
            List<Image> oldList = intro.getImages();
            if (oldList == null) {
                intro.setImages(list);
            } else {
                oldList.addAll(list);
            }
            introService.updateIntro(intro);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200, Message.success, intro);
    }

    @RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody
    ServiceResult insertIntro(int page,int pageSize) {
        return introService.listIntro(page,pageSize);
    }

}
