package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Award;
import com.qgailab.model.po.Patent;
import com.qgailab.service.ExcelService;
import com.qgailab.service.PatentService;
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
 * @date 2019-07-27 09:43
 */
@Controller
@RequestMapping(value = "/patent")
public class PatentController {

    @Autowired
    private PatentService patentService;

    @Autowired
    private ExcelService excelService;

    /**
     * @name 插入专利信息
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult insertPatent(@RequestBody Patent patent) {
        return patentService.insertPatent(patent);
    }

    /**
     * @name 更新专利信息
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    ServiceResult updatePatent(@RequestBody Patent patent) {
        return patentService.updatePatent(patent);
    }

    /**
     * @name 删除专利信息
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/remove")
    public @ResponseBody
    ServiceResult removeNews(Long patentId) {
        return patentService.removePatent(patentId);
    }

    /**
     * @name 查询专利信息
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/select")
    public @ResponseBody
    ServiceResult selectPatent(Long patentId) {
        return patentService.selectParent(patentId);
    }

    /**
     * 分页查询首页信息
     *
     * @param page     页数
     * @param pageSize 一页的最大记录数
     * @return
     * @name listFeature
     * @notice none
     * @author <a href="">郭沛</a>
     * @date 2019-07-27
     */
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public @ResponseBody
    ServiceResult listPatent(int page, int pageSize) {
        return patentService.listPatent(page, pageSize);
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
        return excelService.getTypeList(title,new Patent());
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
    public ServiceResult importPatent(HttpServletRequest request, @RequestParam(value = "excel") MultipartFile excel) {
        ServiceResult rs = null;
        if (excel == null) {
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
                rs = excelService.importExcel(filename, in, new Patent());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return rs;
    }
}
