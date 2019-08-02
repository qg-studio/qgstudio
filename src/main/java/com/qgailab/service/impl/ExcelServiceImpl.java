package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.dao.*;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Award;
import com.qgailab.model.po.Copyright;
import com.qgailab.model.po.News;
import com.qgailab.model.po.Patent;
import com.qgailab.service.ExcelService;
import com.qgailab.service.constants.Message;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author < a href=" ">郭沛</ a>
 * @description 执行Excel文件对数据的导入和导出
 * @date 2019-07-29 19:53
 */
@Service
public class ExcelServiceImpl implements ExcelService {


    @Autowired
    private AwardMapper awardMapper;

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private PatentMapper patentMapper;

    @Autowired
    private CopyrightMapper copyrightMapper;

    @Value(value = "#{conf.export}")
    private String path;

    /**
     * 从Mapper中获取一个类的数据
     *
     * @param object
     * @return ServiceResult
     * @name getTypeList
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult getTypeList(String title, Object object) {
        List<String> listName = new ArrayList<>();
        List<String> listId = new ArrayList<>();
        List list = null;
        Field[] fields = object.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 2; i < fieldNames.length - 2; i++) {
            listName.add(fields[i].getName());
            listId.add(fields[i].getName());
        }
        if (object instanceof Award) {
            PageHelper.startPage(1,60000);
            list = awardMapper.listPageOrderByNumber();
        }
        if (object instanceof News) {
            list = newsMapper.listPageOrderByNumber();
        }
        if (object instanceof Patent) {
            list = patentMapper.listPageOrderByNumber();
        }
        if (object instanceof Copyright) {
            list = copyrightMapper.listPageOrderByNumber();
        }
        ServiceResult sr = exportExcel("荣誉数据导出EXCEL文档", listName, listId, list);
        return sr;
    }

    /**
     * 导出数据到Excel文件
     *
     * @param
     * @return ServiceResult
     * @name exportExcel
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult exportExcel(String title, List headersName, List headersId, List dtoList) {
        //表头--标题栏
        Map<Integer, String> headersNameMap = new HashMap<>();
        Map<Integer, String> titleFieldMap = new HashMap<>();
        int key = 0, value = 0;
        for (int i = 0; i < headersName.size(); i++) {
            if (headersName.get(i)!=null) {
                headersNameMap.put(key, (String) headersName.get(i));
                key++;
            }
            if (headersId.get(i) != null) {
                titleFieldMap.put(value, (String) headersId.get(i));
                value++;
            }
        }
        //声明一个工作簿，包括创建，表格，样式
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet(title);
        sheet.setDefaultColumnWidth((short) 15);
        //生成一个样式
        HSSFCellStyle style = hssfWorkbook.createCellStyle();
        HSSFRow row = sheet.createRow(0);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell cell;
        //取出表格所有标题的value的集合
        Collection collection = headersNameMap.values();
        //表格标题的迭代器
        Iterator<String> iterator = collection.iterator();
        //导出数据：包括导出标题栏以及内容栏
        //根据选择的字段生成表头
        short size = 0;
        while (iterator.hasNext()) {
            cell = row.createCell(size);
            cell.setCellValue(iterator.next().toString());
            cell.setCellStyle(style);
            size++;
        }
        //表格标题一行的字段的集合
        Collection fieldCollection = titleFieldMap.values();
        //总记录的迭代器
        Iterator totalIterator = dtoList.iterator();
        //列序号
        int column = 0;
        while (totalIterator.hasNext()) {
            //记录的迭代器，遍历总记录
            int fieldCell = 0;
            column++;
            row = sheet.createRow(column);
            Object object = totalIterator.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            //获得JavaBean全部属性
            Field[] fields = object.getClass().getDeclaredFields();
            for (short i = 0; i < fields.length; i++) {
                //遍历属性，比对
                Field field = fields[i];
                //属性名
                String fieldName = field.getName();
                //一条字段的集合的迭代器
                Iterator<String> fieldIterator = fieldCollection.iterator();
                //遍历要导出的字段集合
                while (fieldIterator.hasNext()) {
                    //比对JavaBean的属性名，一致就写入，不一致就丢弃
                    if (fieldIterator.next().equals(fieldName)) {
                        String getMethodName = "get"
                                + fieldName.substring(0, 1).toUpperCase()
                                + fieldName.substring(1);
                        Class tCls = object.getClass();
                        try {
                            Method getMethod = tCls.getMethod(getMethodName,
                                    new Class[]{});
                            Object val = getMethod.invoke(object, new Object[]{});
                            String textVal = null;
                            if (val != null) {
                                textVal = String.valueOf(val);
                            } else {
                                textVal = null;
                            }
                            row.createCell((short) fieldCell).setCellValue(textVal);
                            fieldCell++;
                        } catch (SecurityException | NoSuchMethodException |
                                IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return new ServiceResult(200, Message.success,hssfWorkbook);
    }


    /**
     * 从Excel文件导入数据
     *
     * @param
     * @return ServiceResult
     * @name importExcel
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    @Override
    public ServiceResult importExcel(String filename, InputStream in, Object object) {
        ServiceResult result = null;
        //判断是否是excel2007格式
        boolean isxlsx = false;
        if (filename.endsWith("xlsx")) {
            isxlsx = true;
        }
        List<Object> list;
        try {
            Workbook wb = null;
            if (isxlsx) {
                wb = new XSSFWorkbook(in);
            } else {
                wb = new HSSFWorkbook(in);
            }
            //获得第一个表格
            Sheet sheet = wb.getSheetAt(0);
            //获得第一个表格的行迭代器
            Iterator<Row> rows = sheet.rowIterator();
            //略过每列的标题
            rows.next();
            while (rows.hasNext()) {
                //遍历每一行
                Row row = rows.next();
                //获得第一行的迭代器
                Iterator<Cell> cells = row.cellIterator();
                //判断所要打印的数据类型（4中类型）
                if (object instanceof Award) {
                    //Award类型
                    result = parseAward(cells);
                } else if (object instanceof Copyright) {
                    //Copyright类型
                    result = parseCopyright(cells);
                } else if (object instanceof News) {
                    //News类型
                    result = parseNews(cells);
                } else if (object instanceof Patent) {
                    //Patent类型
                    result = parsePatent(cells);
                } else {
                    return new ServiceResult(401, Message.object_not_found);
                }
                //遍历每一行并将数据插入数据库
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return result;
    }

    /**
     * 从Excel打印Award对象的数据到数据库中
     *
     * @param
     * @return ServiceResult
     * @name parseAward
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    private ServiceResult parseAward(Iterator<Cell> cells) {
        Award award = new Award();
        while (cells.hasNext()) {
            //在每一行基础上去遍历每一列
            Cell cell = cells.next();
            int i = cell.getColumnIndex();
            cell.setCellType(CellType.STRING);
            if (award != null) {
                switch (i) {
                    case 0:
                        award.setProject(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 1:
                        award.setGame(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 2:
                        award.setDate(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 3:
                        award.setLevel(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 4:
                        award.setPrize(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 5:
                        award.setInstitution(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 6:
                        award.setWinner(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 7:
                        award.setLeader(String.valueOf(cell.getStringCellValue()));
                        break;
                    default:
                        return new ServiceResult(402,Message.type_not_support);
                }
            }
        }
        if (awardMapper.insertSelective(award) != 1) {
            return new ServiceResult(403, Message.database_exception);
        }

        return new ServiceResult(200, Message.success);
    }

    /**
     * 从Excel打印Patent对象的数据到数据库中
     *
     * @param
     * @return ServiceResult
     * @name parsePatent
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    private ServiceResult parsePatent(Iterator<Cell> cells) {
        Patent patent = new Patent();
        while (cells.hasNext()) {
            //在每一行基础上去遍历每一列
            Cell cell = cells.next();
            int i = cell.getColumnIndex();
            cell.setCellType(CellType.STRING);
            if (patent != null) {
                switch (i) {
                    case 0:
                        patent.setType(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 1:
                        patent.setName(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 2:
                        patent.setZl(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 3:
                        patent.setInventor(String.valueOf(cell.getStringCellValue()));
                        break;
                    default:
                        return new ServiceResult(402,Message.type_not_support);

                }
            }
        }
        if (patentMapper.insertSelective(patent) != 1) {
            return new ServiceResult(403, Message.database_exception);
        }
        return new ServiceResult(200, Message.success);
    }


    /**
     * 从Excel打印News对象的数据到数据库中
     *
     * @param
     * @return ServiceResult
     * @name parseNews
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    private ServiceResult parseNews(Iterator<Cell> cells) {
        News news = new News();
        while (cells.hasNext()) {
            //在每一行基础上去遍历每一列
            Cell cell = cells.next();
            int i = cell.getColumnIndex();
            cell.setCellType(CellType.STRING);
            if (news != null) {
                switch (i) {
                    case 0:
                        news.setTitle(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 1:
                        news.setUrl(String.valueOf(cell.getStringCellValue()));
                        break;
                    default:
                        return new ServiceResult(402,Message.type_not_support);

                }
            }
        }
        if (newsMapper.insertSelective(news) != 1) {
            return new ServiceResult(403, Message.database_exception);
        }
        return new ServiceResult(200, Message.success);
    }



    /**
     * 从Excel打印Copyright对象的数据到数据库中
     *
     * @param
     * @return ServiceResult
     * @name parseCopyright
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    private ServiceResult parseCopyright(Iterator<Cell> cells) {
        Copyright copyright = new Copyright();
        while (cells.hasNext()) {
            //在每一行基础上去遍历每一列
            Cell cell = cells.next();
            int i = cell.getColumnIndex();
            cell.setCellType(CellType.STRING);
            if (copyright != null) {
                switch (i) {
                    case 0:
                        copyright.setName(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 1:
                        copyright.setRn(String.valueOf(cell.getStringCellValue()));
                        break;
                    case 2:
                        copyright.setDate(String.valueOf(cell.getStringCellValue()));
                        break;
                    default:
                        return new ServiceResult(402,Message.type_not_support);

                }
            }
        }
        if (copyrightMapper.insertSelective(copyright) != 1) {
            return new ServiceResult(403, Message.database_exception);
        }
        return new ServiceResult(200, Message.success);
    }
}

