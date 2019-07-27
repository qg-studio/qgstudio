package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Image;

public interface ImageService {

    ServiceResult insertImage(Image image);

    ServiceResult removeImage(Long id);


}
