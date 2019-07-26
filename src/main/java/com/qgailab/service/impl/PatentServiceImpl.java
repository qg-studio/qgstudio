import com.qgailab.dao.PatentMapper;
import com.qgailab.model.po.Patent;
import com.qgailab.service.PatentService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 紫金大佬
 */
public class PatentServiceImpl implements PatentService {

    @Autowired
    PatentMapper patentMapper;

    /**
     *负责插入专利
     * @Param: [patent]
     * @return: java.lang.String
     * @Author: gp
     * @Date: 2019/7/26
     */
    @Override
    public String InsertPatent(Patent patent) {

        if (patent.getType() == null) {
            return ;
        }
        if (patent.getName() == null) {

        }
        if (patent.getInventor() == null) {

        }
        try {
            patentMapper.insert(patent);
        }
        catch () {

        }
    }

    /**
     * 负责删除专利信息
    * @Param: [id]
    * @return: java.lang.String
    * @Author: gp
    * @Date: 2019/7/26
    */
    @Override
    public String DeletePatent(Long id) {
        Patent patent = patentMapper.selectByPrimaryKey(id);
        if (patent == null) {
            return
        }
        else {
            patentMapper.deleteByPrimaryKey(id);
        }
        return ;
    }

    /**
     * 负责更新专利信息
    * @Param: [patent]
    * @return: java.lang.String
    * @Author: gp
    * @Date: 2019/7/26
    */
    @Override
    public String UpdatePatent(Patent patent) {
        Patent patent1 = patentMapper.selectByPrimaryKey(patent.getId());
        if (patent1 == null) {
            return ;
        }
        else {
            try {
                patentMapper.updateByPrimaryKey(patent);
            }
            catch () {

            }
        }
        return ;
    }

    /**
     * 负责查询专利信息
    * @Param: [id]
    * @return: java.lang.String
    * @Author: gp
    * @Date: 2019/7/26
    */
    @Override
    public String SelectParent(Long id) {
        Patent patent = patentMapper.selectByPrimaryKey(id);
        if (patent == null) {
            return ;
        }
        return ;
    }
}
