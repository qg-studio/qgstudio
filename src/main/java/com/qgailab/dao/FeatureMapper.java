package com.qgailab.dao;

import com.qgailab.model.po.Feature;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feature
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feature
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int insert(Feature record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feature
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int insertSelective(Feature record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feature
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    Feature selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feature
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKeySelective(Feature record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feature
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(Feature record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table feature
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKey(Feature record);
}