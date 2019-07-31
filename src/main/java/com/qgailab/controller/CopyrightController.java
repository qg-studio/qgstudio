package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Award;
import com.qgailab.model.po.Copyright;
import com.qgailab.service.CopyrightService;
import com.qgailab.service.ExcelService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 09:11
 */
@Controller
@RequestMapping(value = "/copyright")
public class CopyrightController {

    @Autowired
    private CopyrightService copyrightService;

    @Autowired
    private ExcelService excelService;

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
    @RequestMapping(value = "/export", method = RequestMethod.POST)
    public ServiceResult exportNews(String title) {
        return excelService.getTypeList(title,new Copyright());
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
    public ServiceResult importCopyright(HttpServletRequest request, @RequestParam(value = "excel") MultipartFile[] excel) {
        ServiceResult rs = null;
        if (excel == null || excel.length == 0) {
            return new ServiceResult(400, Message.excel_not_null);
        }
        try {
            String path = request.getSession().getServletContext().getRealPath("/import/");

            String filename = excel.getOriginalFilename();
            File dir = new File(path);
            if(!dir.exists()){
                dir.mkdirs();
            }
            File targetFile = new File(path, filename);
            try {
                excel.transferTo(targetFile);
            }catch (Exception e) {
                e.printStackTrace();
            }
            InputStream in = new FileInputStream(targetFile);
            if (filename.endsWith(".xls") || filename.endsWith(".xlsx")) {
                rs = excelService.importExcel(filename, in, new Copyright());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return rs;
    }
}
