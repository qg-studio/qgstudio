package com.qgailab.service;

import com.qgailab.exception.UploadException;
import com.qgailab.model.po.Image;
import com.qgailab.service.constants.Message;
import com.qgailab.util.UploadUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-26 21:28
 */
public interface UploadService {
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
    List<Image> uploadImage(String fuuid, MultipartFile[] uploads, String path);


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
    List<Image> uploadImage(String fuuid, MultipartFile[] uploads, String path, String description);


    File uploadFile(MultipartFile file, String path);
}


