package com.qgailab.dao;

import com.qgailab.model.po.Copyright;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopyrightMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copyright
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copyright
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int insert(Copyright record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copyright
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int insertSelective(Copyright record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copyright
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    Copyright selectByPrimaryKey(Long id);

    List<Copyright> listPageOrderByNumber();

    int selectCount();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copyright
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKeySelective(Copyright record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table copyright
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKey(Copyright record);

    /**
     * 删除所有数据
     * @return
     */
    int deleteAll();
}