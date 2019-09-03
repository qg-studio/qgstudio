package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public interface ExcelService {

    /**
     * 从Mapper中获取一个类的数据
     * @name getTypeList
     * @param  object
     * @return List<T>
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
   ServiceResult getTypeList(String title, Object object);

    /**
     * 导出数据到Excel文件
     * @name exportExcel
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
     ServiceResult exportExcel(String title, List<String> headersName, List<String> headersId, List dtoList);

    /**
     * 从Excel文件导入数据
     * @name importExcel
     * @param
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult importExcel(String filename, InputStream in, Object object, Boolean cover) throws IOException;

}
