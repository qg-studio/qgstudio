package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Field;
import com.qgailab.model.po.History;
import com.qgailab.model.po.Image;
import com.qgailab.model.po.History;
import com.qgailab.service.HistoryService;
import com.qgailab.service.UploadService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 10:03
 */
@RestController
@RequestMapping(value = "/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;
    @Autowired
    private UploadService uploadService;


    /**
     * 负责上传图片
     *
     * @name uploadImage
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult uploadImage(HttpServletRequest request,String description,
                              @RequestParam(value = "historyId") Long historyId, @RequestParam(value = "uploads") MultipartFile[] uploads) {
        if (uploads == null || uploads.length == 0) {
            return new ServiceResult(400, Message.image_not_null);
        }
        History history = null;
        try {
            ServiceResult result = historyService.selectHistory(historyId);
            if (result.getStatus() != 200) {
                return result;
            }
            String path = request.getSession().getServletContext().getRealPath("/upload/");
            history = (History) result.getData();
            //保存图片数组
            List<Image> list = uploadService.uploadFile(history.getUuid(), uploads, path,description);
            //更新到history中
            List<Image> oldList = history.getImages();
            if (oldList == null) {
                history.setImages(list);
            } else {
                oldList.addAll(list);
            }
            historyService.updateHistory(history);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, history);
    }



    /**
     * @param
     * @return ServiceResult
     * @name 插入大事记信息
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult insertHistory(@RequestBody History history) {
        return historyService.insertHistory(history);
    }

    /**
     * 更新大事记信息
     *
     * @name updateHistory
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult updateHistory(@RequestBody History history) {
        return historyService.updateHistory(history);
    }



    /**
     * 删除大事记信息
     *
     * @name removeHistory
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult removeHistory(Long historyId) {
        return historyService.removeHistory(historyId);
    }


    /**
     * 分页查询大事记信息
     *
     * @param page     页数
     * @param pageSize 一页的最大记录数
     * @return
     * @name listHistory
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public ServiceResult listHistory(int page, int pageSize) {
        return historyService.listHistory(page, pageSize);
    }
}
