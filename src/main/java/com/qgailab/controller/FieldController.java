package com.qgailab.controller;

import com.qgailab.dao.FieldMapper;
import com.qgailab.exception.NotImageException;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Field;
import com.qgailab.model.po.Image;
import com.qgailab.service.FieldService;
import com.qgailab.service.ImageService;
import com.qgailab.service.UploadService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author < a href=" ">郭沛</ a>
 * @description
 * @date 2019-07-27 10:04
 */
@Controller
@RequestMapping(value = "/field")
public class FieldController {


    @Autowired
    private UploadService uploadService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private FieldMapper fieldMapper;


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
    ServiceResult uploadImage(HttpServletRequest request, @RequestParam(value = "fieldId") Long fieldId, @RequestParam(value = "uploads") MultipartFile[] uploads) {
        if (uploads == null || uploads.length == 0) {
            return new ServiceResult(400, Message.image_not_null);
        }
        Field field = null;
        try {
            ServiceResult result = fieldService.selectField(fieldId);
            if (result.getStatus() != 200) {
                return result;
            }
            String path = request.getSession().getServletContext().getRealPath("/upload/");
            field = (Field) result.getData();
            //保存图片数组
            List<Image> list = uploadService.uploadImage(field.getUuid(), uploads, path);
            //更新到field中
            List<Image> oldList = field.getImages();
            imageService.removeImageList(path, oldList);
            if (oldList != null) {
                oldList.addAll(list);
            } else {
                field.setImages(list);
            }
            fieldService.updateField(field);
        } catch (NotImageException e) {
            return new ServiceResult(400,Message.image_type_error);
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, field);
    }


    @Autowired
    private FieldService fieldService;

    /**
     * @param
     * @return ServiceResult
     * @name 插入领域信息
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult insertField(@RequestBody Field field) {
        return fieldService.insertField(field);
    }

    /**
     * 更新研究方向信息
     *
     * @name updateField
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult updateField(Long id, String name, String description, @RequestParam(value = "front", required = false) MultipartFile front,
                              @RequestParam(value = "end", required = false) MultipartFile end, HttpServletRequest request) {

        Field field = new Field(id,null,name,null,null,null,null,null,description);

        String path = request.getSession().getServletContext().getRealPath("/upload/");

        ServiceResult result;

        Field realField = fieldMapper.selectByPrimaryKey(field.getId());
        if (front != null && !front.isEmpty()) {
            result = imageService.updateImage(front, path, realField.getImages().get(0).getId());
            if (result.getStatus() != 200) {
                return result;
            }
            Image frontImage = (Image) result.getData();
            field.setFront(frontImage.getFilename());
        }
        if (end != null && !end.isEmpty()) {
            result = imageService.updateImage(end, path, realField.getImages().get(1).getId());
            if (result.getStatus() != 200) {
                return result;
            }
            Image endImage = (Image) result.getData();
            field.setEnd(endImage.getFilename());
        }
        return fieldService.updateField(field);
    }


    /**
     * 删除研究方向信息
     *
     * @name removeField
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult removeField(Long fieldId) {
        return fieldService.removeField(fieldId);
    }


    /**
     * 分页查询首页信息
     *
     * @param page     页数
     * @param pageSize 一页的最大记录数
     * @return
     * @name listField
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    ServiceResult listField(int page, int pageSize) {

        ServiceResult result = fieldService.listField(page, pageSize);
        if (result.getStatus() != 200) {
            return result;
        }
        List<Field> list = (List) result.getData();
        for (int i = 0; i < list.size(); i++) {
            Field field = list.get(i);
            field.setFront(field.getImages().get(0).getFilename());
            field.setEnd(field.getImages().get(1).getFilename());
        }
        result.setData(list);
        return result;
    }

}
