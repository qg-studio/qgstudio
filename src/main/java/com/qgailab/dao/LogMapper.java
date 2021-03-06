package com.qgailab.dao;

import com.qgailab.model.po.Log;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbg.generated Mon Jul 29 09:49:52 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbg.generated Mon Jul 29 09:49:52 CST 2019
     */
    int insert(Log record);


    List<Log> listPage();

    int selectCount();


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbg.generated Mon Jul 29 09:49:52 CST 2019
     */
    int insertSelective(Log record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbg.generated Mon Jul 29 09:49:52 CST 2019
     */
    Log selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbg.generated Mon Jul 29 09:49:52 CST 2019
     */
    int updateByPrimaryKeySelective(Log record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbg.generated Mon Jul 29 09:49:52 CST 2019
     */
    int updateByPrimaryKey(Log record);
}