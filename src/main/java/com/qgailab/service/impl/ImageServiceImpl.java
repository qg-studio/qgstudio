package com.qgailab.service.impl;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Image;
import com.qgailab.service.ImageService;
import org.springframework.stereotype.Service;

/**
 * 对图片进行增查
 * @program: qgstudio
 * @author: gp
 * @create: 2019-07-26 16:22
 **/
@Service
public class ImageServiceImpl implements ImageService {


    @Override
    public ServiceResult InsertImage(Image image) {
        return null;
    }

    @Override
    public ServiceResult RemoveImage(Long id) {
        return null;
    }
}
