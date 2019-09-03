import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Award;
import com.qgailab.model.po.News;
import com.qgailab.model.po.User;
import com.qgailab.service.ExcelService;
import com.qgailab.service.impl.ExcelServiceImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-25 16:42
 */
public class Test {

    @org.junit.Test
    public void test(){
//        News news = new News();
        Award award = new Award();
        ServiceResult sr;
//        ServiceResult sr = exportBeanExcelUtil.exportExcel("测试POI导出EXCEL文档", listName, listId, list);
    }

    @org.junit.Test
    public void test1() {
        User user = new User();
        user.setUsername("guo");
        Class cl = user.getClass();
        try {
            Field f = f = cl.getDeclaredField("username");;
            f.setAccessible(true);
            Object object = f.get(user);
            System.out.println(cl);
            System.out.println(f);
            System.out.println(object);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }



}
