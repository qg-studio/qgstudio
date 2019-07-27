package com.qgailab.dao;

import com.qgailab.model.po.History;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int insert(History record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int insertSelective(History record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    History selectByPrimaryKey(Long id);

    List<History> listPage(int page, int pageSize);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKeySelective(History record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(History record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table history
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKey(History record);
}