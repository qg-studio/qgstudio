package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Image;

public interface ImageService {

    /**
     * 负责移除一张图片
     *
     * @name removeImage
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    ServiceResult removeImage(String path,Long id);

}
