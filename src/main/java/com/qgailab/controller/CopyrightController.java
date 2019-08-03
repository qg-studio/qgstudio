package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Award;
import com.qgailab.model.po.Copyright;
import com.qgailab.model.po.News;
import com.qgailab.service.CopyrightService;
import com.qgailab.service.ExcelService;
import com.qgailab.service.UploadService;
import com.qgailab.service.constants.Message;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 09:11
 */
@RestController
@RequestMapping(value = "/copyright")
public class CopyrightController {

    @Autowired
    private CopyrightService copyrightService;

    @Autowired
    private ExcelService excelService;

    @Autowired
    private UploadService uploadService;

    /**
    * @name 插入著作权信息
    * @param
    * @return ServiceResult
    * @notice none
    * @author < a href=" ">郭沛</ a>
    * @date
    */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult insertCopyright(@RequestBody Copyright copyright) {
        return copyrightService.insertCopyright(copyright);
    }

    /**
     * @name 更新著作权信息
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult updateCopyright(@RequestBody Copyright copyright) {
        return copyrightService.updateCopyright(copyright);
    }

    /**
     * @name 删除著作权信息
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/remove")
    public @ResponseBody
    ServiceResult removeCopyright(Long copyrightId) {
        return copyrightService.removeCopyright(copyrightId);
    }

    /**
     * @name 查询著作权信息
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/select")
    public @ResponseBody
    ServiceResult selectCopyright(Long copyrightId) {
        return copyrightService.selectCopyright(copyrightId);
    }

    /**
     * 分页查询首页信息
     *
     * @param page     页数
     * @param pageSize 一页的最大记录数
     * @return
     * @name listCopyright
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST,RequestMethod.GET})
    public @ResponseBody
    ServiceResult listCopyright(int page, int pageSize) {
        return copyrightService.listCopyright(page, pageSize);
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
    public ServiceResult exportNews(String title, HttpServletResponse resp) {
        ServiceResult result = excelService.getTypeList(title, new Copyright());
        OutputStream os = null;
        try {
            if (result.getStatus() == 200) {
                HSSFWorkbook workbook = (HSSFWorkbook) result.getData();
                resp.setHeader("content-disposition", "attachment;filename=" + "copyright_export.xls");
                os = resp.getOutputStream();
                workbook.write(os);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 从Excel文件导入数据
     * @name importCopyright
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public ServiceResult importCopyright(HttpServletRequest request, @RequestParam(value = "file") MultipartFile[] file) {
        ServiceResult result = null;
        if (file == null || file.length == 0) {
            return new ServiceResult(400, Message.excel_not_null);
        }
        try {
            String path = request.getSession().getServletContext().getRealPath("/import/");
            for (int i = 0; i < file.length; i++) {
                String filename = file[i].getOriginalFilename();
                File targetFile = uploadService.uploadFile(file[i],path);
                InputStream in = new FileInputStream(targetFile);
                if (filename.endsWith(".xls") || filename.endsWith(".xlsx")) {
                    result = excelService.importExcel(filename, in, new Copyright());
                    if (result.getStatus() != 200) {
                        return result;
                    }
                }else {
                    return new ServiceResult(401,Message.type_not_support);
                }
                targetFile.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return result;
    }
}
