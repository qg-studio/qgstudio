import com.qgailab.dao.PatentMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Patent;
import com.qgailab.service.PatentService;
import com.qgailab.service.constants.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 紫金大佬
 */
@Service
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
    public ServiceResult InsertPatent(Patent patent) {

        if (patent == null || patent.getType() == null || patent.getInventor() == null || patent.getName() == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            patentMapper.insertSelective(patent);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success);
    }


    /**
     * 负责删除专利信息
    * @Param: [id]
    * @return: java.lang.String
    * @Author: gp
    * @Date: 2019/7/26
    */
    @Override
    public ServiceResult DeletePatent(Long id) {

        Patent patent = patentMapper.selectByPrimaryKey(id);
        if (patent == null) {
            return new ServiceResult(401,Message.patent_not_found);
        }
        try {
            patentMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500,Message.please_retry);
        }
        return new ServiceResult(200,Message.success);
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

        if (patent == null) {

        }

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
            tyutfthgffgdgf;
            return ;
        }
        return 111;
    }
}
