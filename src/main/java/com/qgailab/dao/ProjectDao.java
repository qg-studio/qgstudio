package com.qgailab.dao;

import com.qgailab.model.po.Project;

import java.math.BigInteger;

public interface ProjectDao {

    /**
     * 根据项目id查找相关信息
     * @param id
     * @return
     */
    Project getProjectById(BigInteger id);

    void removeProjectById(BigInteger id);

    void updateTitleById(BigInteger id);

    void updateDescriptionById(BigInteger id);

    /**
     * 更新图片未写
     */


}
