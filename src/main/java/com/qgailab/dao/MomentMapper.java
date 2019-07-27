package com.qgailab.dao;

import com.qgailab.model.po.Award;
import com.qgailab.model.po.Moment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MomentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int insert(Moment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int insertSelective(Moment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    Moment selectByPrimaryKey(Long id);


    List<Moment> listPage(int page, int pageSize);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKeySelective(Moment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table moment
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKey(Moment record);
}