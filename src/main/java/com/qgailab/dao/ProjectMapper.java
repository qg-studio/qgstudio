package com.qgailab.dao;

import com.qgailab.model.po.Award;
import com.qgailab.model.po.Project;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int insert(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int insertSelective(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    Project selectByPrimaryKey(Long id);

    List<Project> listPage(int page, int pageSize);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKeySelective(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table project
     *
     * @mbg.generated Thu Jul 25 21:46:07 CST 2019
     */
    int updateByPrimaryKey(Project record);
}