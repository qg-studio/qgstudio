package com.qgailab.util;

import com.qgailab.dao.AwardMapper;
import com.qgailab.dao.FeatureMapper;
import com.qgailab.dao.ImageMapper;
import com.qgailab.model.po.Award;
import com.qgailab.model.po.Feature;
import com.qgailab.model.po.Image;
import com.qgailab.model.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-25 15:37
 */
public class TestUtil {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession(true);
        ImageMapper imageMapper = sqlSession.getMapper(ImageMapper.class);
        AwardMapper awardMapper = sqlSession.getMapper(AwardMapper.class);
        FeatureMapper featureMapper = sqlSession.getMapper(FeatureMapper.class);

        for (int i = 0; i < 5000; i++) {
            Award award = new Award();
            award.setGame("挑战杯");
            award.setInstitution("中科院");
            award.setProject("矿工帽项目");
            award.setWinner("曾华琛");
            award.setLevel("国家级");
            award.setPrize("特等奖");
            awardMapper.insertSelective(award);
        }

//        User user = new User();
//        user.setUsername("test3");
//        user.setPassword("1234");
//        user.setType("USER");
//
//        Award award = awardMapper.selectByPrimaryKey(1L);
//        Feature feature = featureMapper.selectByPrimaryKey(1L);
//        imageMapper.selectByPrimaryKey(10L);
//        List<Image> image = imageMapper.listByFuuid("5c071e13afa54897b485378aae8410a2");
//
//
//        System.out.println(feature);
//        System.out.println(award);
//        System.out.println(image.get(1));
//        System.out.println("id = " + user.getId());

    }


}
