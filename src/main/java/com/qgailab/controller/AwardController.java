package com.qgailab.controller;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Award;
import com.qgailab.service.AwardService;
import com.qgailab.service.ExcelService;
import com.qgailab.service.UploadService;
import com.qgailab.service.constants.Message;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author < a href=" ">郭沛</ a>
 * @description
 * @date 2019-07-27 08:29
 */
@RestController
@RequestMapping(value = "/award")
public class AwardController {

    @Autowired
    private AwardService awardService;
    @Autowired
    private ExcelService excelService;
    @Autowired
    private UploadService uploadService;


    /**
     * @param
     * @return ServiceResult
     * @name 插入奖项
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ServiceResult insertAward(@RequestBody Award award) {
        return awardService.insertAward(award);
    }

    /**
     * @param
     * @return ServiceResult
     * @name 更新奖项
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ServiceResult updateAward(@RequestBody Award award) {
        return awardService.updateAward(award);
    }

    /**
     * @param
     * @return ServiceResult
     * @name 删除奖项
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/remove")
    public ServiceResult removeAward(Long awardId) {
        return awardService.removeAward(awardId);
    }

    /**
     * @param
     * @return ServiceResult
     * @name 查询奖项
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
    @RequestMapping(value = "/list", method = {RequestMethod.POST, RequestMethod.GET})
    public ServiceResult listAward(int page, int pageSize) {
        return awardService.listAward(page, pageSize);
    }

    /**
     * @param
     * @return ServiceResult
     * @name 导出数据到Excel文档
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/export", method = {RequestMethod.POST, RequestMethod.GET})
    public ServiceResult exportAward(String title, HttpServletResponse resp) {
        ServiceResult result = excelService.getTypeList(title, new Award());
        OutputStream os = null;
        try {
            if (result.getStatus() == 200) {
                HSSFWorkbook workbook = (HSSFWorkbook) result.getData();
                resp.setHeader("content-disposition", "attachment;filename=" + "award_export.xls");
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
     * 从Excel文件导入数据，只进行插入数据
     *
     * @param
     * @return ServiceResult
     * @name importAward
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    public ServiceResult importAward(HttpServletRequest request, @RequestParam(value = "file") MultipartFile[] file,
                                     Boolean cover) {
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
                    result = excelService.importExcel(filename, in, new Award(), cover);
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

