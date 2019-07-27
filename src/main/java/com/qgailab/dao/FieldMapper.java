package com.qgailab.dao;

import com.qgailab.model.po.Field;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table field
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table field
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int insert(Field record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table field
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int insertSelective(Field record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table field
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    Field selectByPrimaryKey(Long id);

    List<Field> listPage(int page, int pageSize);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table field
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKeySelective(Field record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table field
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(Field record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table field
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKey(Field record);
}