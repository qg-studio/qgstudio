package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Project;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {
    /**
     * 插入项目信息
     * @Param: project
     * @return: ServiceResult
     * @Author: gp
     * @Date: 2019/7/26
     */
    ServiceResult insertProject(Project project);

    /**
     * 删除项目信息
     * @Param: [id]
     * @return: ServiceResult
     * @Author: gp
     * @Date: 2019/7/26
     */
    ServiceResult removeProject(Long id);

    /**
     * 负责更新项目信息
     * @Param: [project]
     * @return: ServiceResult
     * @Author: gp
     * @Date: 2019/7/26
     */
    ServiceResult updateProject(Project project);

    /**
     * 负责查询项目信息
     * @Param: id
     * @return: ServiceResult
     * @Author: gp
     * @Date: 2019/7/26
     */
    ServiceResult selectProject(Long id);

    /**
     * 返回信息点
     *
     * @param page  页数
     * @param pageSize 一页最大记录数
     * @name listProject
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult listProject(int page, int pageSize);

}
