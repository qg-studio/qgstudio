/*
 * Copyright (c) 2019.  黄钰朝
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.qgailab.util;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;


/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @program wechat
 * @description 用于上传文件
 * @date 2019-04-19 13:31
 */
public class UploadUtils {


    /**
     * 生成唯一文件名
     *
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019/4/19
     */
    public static String getUUIDFilename(String originFilename) {
        String filename = UUIDUtils.getUUID() + originFilename.substring(originFilename.lastIndexOf("."));
        return filename;
    }

    /**
     * 校验图片格式
     *
     * @param
     * @return
     * @name isImage
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-08-02
     */
    public static boolean isImage(File resFile) {
        ImageInputStream iis = null;
        try {
            iis = ImageIO.createImageInputStream(resFile);
            Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
            if (iter.hasNext()) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (iis != null) {
                try {
                    iis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }




}
