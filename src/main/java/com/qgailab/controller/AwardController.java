package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Award;
import com.qgailab.model.po.Intro;
import com.qgailab.service.AwardService;
import com.qgailab.service.ExcelService;
import com.qgailab.service.constants.Message;
import com.qgailab.service.impl.ExcelServiceImpl;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 08:29
 */
@RestController
@RequestMapping(value = "/award")
public class AwardController {

    @Autowired
    private AwardService awardService;
    @Autowired
    private ExcelService excelService;


    /**
    * @name 插入奖项
    * @param
    * @return ServiceResult
    * @notice none
    * @author < a href=" ">郭沛</ a>
    * @date
    */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ServiceResult insertAward(@RequestBody Award award) {
        return awardService.insertAward(award);
    }

    /**
     * @name 更新奖项
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ServiceResult updateAward(@RequestBody Award award) {
        return awardService.updateAward(award);
    }

    /**
     * @name 删除奖项
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/remove")
    public ServiceResult removeAward(Long awardId) {
        return awardService.removeAward(awardId);
    }

    /**
     * @name 查询奖项
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/select")
    public ServiceResult selectAward(Long awardId) {
        return awardService.selectAward(awardId);
    }

    /**
     * 分页查询首页信息
     *
     * @param page     页数
     * @param pageSize 一页的最大记录数
     * @return
     * @name listAward
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/list",method = {RequestMethod.POST, RequestMethod.GET})
    public ServiceResult listAward(int page, int pageSize) {
        return awardService.listAward(page, pageSize);
    }

    /**
     * @name 导出数据到Excel文档
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/export", method = {RequestMethod.POST,RequestMethod.GET})
    public ServiceResult exportAward(String title) {
        return excelService.getTypeList(title, new Award());
    }

    /**
     * 从Excel文件导入数据
     * @name importAward
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public ServiceResult importAward(HttpServletRequest request, @RequestParam(value = "excel")MultipartFile[] excel) {
        ServiceResult result = null;
        if (excel == null || excel.length == 0) {
            return new ServiceResult(400, Message.excel_not_null);
        }
        try {
            String path = request.getSession().getServletContext().getRealPath("/import/");
            for (int i = 0; i < excel.length; i++) {
                String filename = excel[i].getOriginalFilename();
                File dir = new File(path);
                if(!dir.exists()){
                    dir.mkdirs();
                }
                File targetFile = new File(path, filename);
                try {
                    excel[i].transferTo(targetFile);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                InputStream in = new FileInputStream(targetFile);
                if (filename.endsWith(".xls") || filename.endsWith(".xlsx")) {
                    result = excelService.importExcel(filename, in, new Award());
                }
                targetFile.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return rs;
    }
}
