package com.qgailab.service.impl;

import com.qgailab.dao.ImageMapper;
import com.qgailab.exception.UploadException;
import com.qgailab.model.po.Image;
import com.qgailab.service.UploadService;
import com.qgailab.service.constants.Message;
import com.qgailab.util.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-26 21:28
 */
@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private ImageMapper imageMapper;

    /**
     * 负责将上传的图片数组保存到指定路径，并且插入数据库，返回image对象集合
     *
     * @param fuuid   图片所属的对象的uuid
     * @param uploads 上传的文件数组
     * @param path    文件上传路径
     * @return
     * @name uploadImage
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    @Override
    public List<Image> uploadImage(String fuuid, MultipartFile[] uploads, String path) {
        return uploadImage(fuuid, uploads, path, null);
    }

    /**
     * 负责将上传的图片数组保存到指定路径，并且插入数据库，返回image对象集合
     *
     * @param fuuid       图片所属的对象的uuid
     * @param uploads     上传的文件数组
     * @param path        文件上传路径
     * @param description
     * @return
     * @name uploadImage
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    @Override
    public List<Image> uploadImage(String fuuid, MultipartFile[] uploads, String path, String description) {
        List<Image> imageList = new LinkedList<>();
        MultipartFile upload;
        for (int i = 0; i < uploads.length; i++) {
            Image image = new Image();
            if (description != null && !description.trim().isEmpty()) {
                image.setDescription(description);
            }
            upload = uploads[i];
            if (upload == null || upload.isEmpty()) {
                throw new UploadException(Message.image_not_null.toString());
            }
            File file;
            try {
                //初始化路径
                File dir = new File(path);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                //获取文件名
                String originFilename = upload.getOriginalFilename();
                if (originFilename == null) {
                    throw new UploadException(Message.filename_not_null.toString());
                }
                String filename = UploadUtils.getUUIDFilename(originFilename);

                //保存文件
                file = new File(dir.getAbsolutePath() + File.separator + filename);
                upload.transferTo(file);

                //插入数据库
                image.setFuuid(fuuid);
                image.setFilename(filename);
                imageMapper.insertSelective(image);
                imageList.add(image);
            } catch (Exception e) {
                throw new UploadException(Message.please_retry.toString());
            }
        }
        return imageList;
    }

    @Override
    public File uploadFile(MultipartFile file, String path){
        String filename = file.getOriginalFilename();
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File targetFile = new File(path, filename);
        if(targetFile.exists()){
            targetFile.delete();
        }
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return targetFile;
    }
}
