package com.qgailab.dao;

import com.qgailab.model.po.Patent;
import org.springframework.stereotype.Repository;


@Repository
public interface PatentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patent
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patent
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int insert(Patent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patent
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int insertSelective(Patent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patent
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    Patent selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patent
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKeySelective(Patent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table patent
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKey(Patent record);
}