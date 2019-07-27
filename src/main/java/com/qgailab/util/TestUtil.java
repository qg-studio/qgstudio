package com.qgailab.util;

import com.qgailab.dao.ImageMapper;
import com.qgailab.dao.UserMapper;
import com.qgailab.model.po.Image;
import com.qgailab.model.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

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
        SqlSession sqlSession= factory.openSession(true);
        ImageMapper imageMapper =  sqlSession.getMapper(ImageMapper.class);
        User user = new User();
        user.setUsername("test3");
        user.setPassword("1234");
        user.setType("USER");

        imageMapper.selectByPrimaryKey(10L);
        List<Image> image = imageMapper.selectByFuuid("5c071e13afa54897b485378aae8410a2");

        System.out.println("id = "+user.getId());
    }
}
