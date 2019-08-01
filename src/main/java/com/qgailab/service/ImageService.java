package com.qgailab.service;

import com.qgailab.exception.UploadException;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Image;
import com.qgailab.service.constants.Message;
import com.qgailab.util.UploadUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface ImageService {

    /**
     * 负责移除一张图片
     *
     * @name removeImage
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    ServiceResult removeImage(String path, Long id);

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
    ServiceResult removeImageList(String path, List<Image> images);

    /**
     * 用于更新图片描述
     *
     * @return
     * @name updateImage
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-29
     */
    ServiceResult updateImage(Image image);

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
    ServiceResult updateImage(MultipartFile upload, String path, Long imageId);

}
