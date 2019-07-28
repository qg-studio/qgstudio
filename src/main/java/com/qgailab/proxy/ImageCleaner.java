package com.qgailab.proxy;

import com.qgailab.dao.ImageMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Image;
import com.qgailab.service.ImageService;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Filter;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description 用于在删除操作之后连带删除其所带的图片
 * @date 2019-07-28 07:42
 */
@Service
@Aspect
public class ImageCleaner {

    @Autowired
    private ImageService imageService;
    @Autowired
    private ImageMapper imageMapper;

    @Value(value = "#{conf.path}")
    private String path;

    /**
     * 负责获取被删除对象的uuid,并删除该uuid对应的图片
     *
     * @param result service处理的结果
     * @return
     * @name afterRemove
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-28
     */
    @AfterReturning(value = "execution(* com.qgailab.service.impl.*ServiceImpl.remove*(..))&&!execution(* com.qgailab.service.impl.*ServiceImpl.removeImage*(..))", returning = "result")
    private void afterRemove(ServiceResult result) {
        String uuid = null;

        if (result.getStatus() == 200) {
            Object obj = result.getData();
            try {
                Method method = obj.getClass().getDeclaredMethod("getUuid");
                uuid = (String) method.invoke(obj);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            List<Image> images = imageMapper.listByFuuid(uuid);
            imageService.removeImageList(path, images);
        }
    }


}
