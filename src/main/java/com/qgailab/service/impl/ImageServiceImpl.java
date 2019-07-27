package com.qgailab.service.impl;

import com.qgailab.dao.ImageMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Image;
import com.qgailab.service.ImageService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * 对图片进行增查
 *
 * @program: qgstudio
 * @author: gp
 * @create: 2019-07-26 16:22
 **/
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageMapper imageMapper;

    /**
     * 负责移除一张图片
     *
     * @param id
     * @name removeImage
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    @Override
    public ServiceResult removeImage(String path, Long id) {
        Image image;

        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }

        try {
            //查询图片是否存在
            image = imageMapper.selectByPrimaryKey(id);
            if (image == null) {
                return new ServiceResult(401, Message.image_not_found);
            }
            //删除文件
            File file = new File(path + image.getFilename());
            if (!file.exists()) {
                return new ServiceResult(402, Message.image_has_lost, file);
            }
            file.delete();

            //删除图片
            if (imageMapper.deleteByPrimaryKey(id) != 1) {
                return new ServiceResult(403, Message.database_exception);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.database_exception);
        }
        return new ServiceResult(200, Message.success, image);
    }


    public ServiceResult removeImageList(String path, List<Image> images) {
        if (images == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        //遍历删除图片
        for (Image image : images) {
            ServiceResult result = removeImage(path, image.getId());
            if (result.getStatus() != 200) {
                return result;
            }
        }
        return new ServiceResult(200, Message.success, images);
    }

}