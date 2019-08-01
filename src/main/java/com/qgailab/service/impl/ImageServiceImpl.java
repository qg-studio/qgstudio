package com.qgailab.service.impl;

import com.qgailab.annotation.Permmision;
import com.qgailab.dao.ImageMapper;
import com.qgailab.exception.PathNotExistException;
import com.qgailab.exception.UploadException;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Image;
import com.qgailab.service.ImageService;
import com.qgailab.service.constants.Message;
import com.qgailab.service.constants.Module;
import com.qgailab.service.constants.Operation;
import com.qgailab.util.UploadUtils;
import com.qgailab.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
    @Permmision(module = Module.image, operation = Operation.REMOVE)
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
                throw new PathNotExistException("图片路径不存在");
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

    /**
     * 负责更新图片文件
     *
     * @param upload 重新上传的图片
     * @return
     * @name updateImage
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-08-01
     */
    @Override
    public ServiceResult updateImage(MultipartFile upload, String path, Long imageId) {

        Image image = null;
        try {
            image = imageMapper.selectByPrimaryKey(imageId);
            if (image == null) {
                return new ServiceResult(401, Message.image_not_found);
            }
            File file;
            //初始化路径
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //删除原有图片
            File oldFile = new File(dir.getAbsolutePath() + File.separator + image.getFilename());
            oldFile.delete();
            //获取文件名
            String originFilename = upload.getOriginalFilename();
            if (originFilename == null) {
                throw new UploadException(Message.filename_not_null.toString());
            }
            String filename = UploadUtils.getUUIDFilename(originFilename);
            //保存文件
            file = new File(dir.getAbsolutePath() + File.separator + filename);
            upload.transferTo(file);
            image.setFilename(filename);
            imageMapper.updateByPrimaryKeySelective(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ServiceResult(200, Message.success, image);
    }

    /**
     * 负责删除图片集合
     *
     * @param path   图片路径
     * @param images 图片集合
     * @return
     * @name removeImageList
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-28
     */
    @Override
    @Permmision(module = Module.image, operation = Operation.REMOVE)
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

    /**
     * 用于更新图片描述
     *
     * @param image
     * @return
     * @name updateImage
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-29
     */
    @Override
    @Permmision(module = Module.image, operation = Operation.UPDATE)
    public ServiceResult updateImage(Image image) {
        if (image == null || image.getId() == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }

        try {
            //描述不可为空
            if (image.getDescription() == null || image.getDescription().trim().isEmpty()) {
                return new ServiceResult(401, Message.description_not_null);
            }
            String message = validate(image);
            if (message != null) {
                return new ServiceResult(402, message, image);
            }
            if (imageMapper.selectByPrimaryKey(image.getId()) == null) {
                return new ServiceResult(403, Message.image_not_found);
            }
            if (imageMapper.updateByPrimaryKeySelective(image) != 1) {
                return new ServiceResult(404, Message.database_exception);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, image);
    }

    /**
     * 用于校验数据
     *
     * @return
     * @name validate
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-30
     */
    private String validate(Image image) {
        if (!ValidationUtils.inMaxVarcharSize(image.getDescription())) {
            return Message.description_too_long.toString();
        } else {
            return null;
        }
    }
}
