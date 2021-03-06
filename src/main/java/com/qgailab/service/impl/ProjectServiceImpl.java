package com.qgailab.service.impl;

import com.github.pagehelper.PageHelper;
import com.qgailab.annotation.Permmision;
import com.qgailab.dao.ProjectMapper;
import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.Intro;
import com.qgailab.model.po.Patent;
import com.qgailab.model.po.Project;
import com.qgailab.service.ProjectService;
import com.qgailab.service.constants.Message;
import com.qgailab.service.constants.Module;
import com.qgailab.service.constants.Operation;
import com.qgailab.util.UUIDUtils;
import com.qgailab.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 项目的增删查改
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-27 12:03
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;
    /**
     * 负责插入一条信息点
     *
     * @param project
     * @name insertProject
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    @Override
    @Permmision(module = Module.project, operation = Operation.INSERT)

    public ServiceResult insertProject(Project project) {
        if (project == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (project.getTitle() == null || project.getTitle().trim().isEmpty()) {
                return new ServiceResult(401, Message.title_not_null);
            }
            if (project.getDescription() == null || project.getDescription().trim().isEmpty()) {
                project.setDescription("");
            }
            String message = validate(project);
            if (message != null) {
                return new ServiceResult(402, message, project);
            }
            project.setUuid(UUIDUtils.getUUID());
            if (projectMapper.insertSelective(project) != 1) {
                return new ServiceResult(403, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, project);
    }

    /**
     * 负责删除一条信息点
     *
     * @param id
     * @name removeProject
     * @notice none
     * @author <a href=" ">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    @Permmision(module = Module.project, operation = Operation.REMOVE)

    public ServiceResult removeProject(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Project project;
        try {
            project = projectMapper.selectByPrimaryKey(id);
            if (project == null) {
                return new ServiceResult(401, Message.project_not_found);
            }
            if (projectMapper.deleteByPrimaryKey(id) != 1) {
                return new ServiceResult(402, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, project);
    }

    /**
     * 负责更新一条信息点
     *
     * @param project
     * @name updateProject
     * @notice none
     * @author <a href=" ">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    @Permmision(module = Module.project, operation = Operation.UPDATE)

    public ServiceResult updateProject(Project project) {
        if (project == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        try {
            if (project.getId() == null) {
                return new ServiceResult(401, Message.parameter_not_enough);
            }
            if (project.getTitle() == null || project.getTitle().trim().isEmpty()) {
                return new ServiceResult(402, Message.title_not_null);
            }
            if (project.getDescription() == null || project.getDescription().trim().isEmpty()) {
                project.setDescription("");
            }
            String message = validate(project);
            if (message != null) {
                return new ServiceResult(403, message, project);
            }
            if (projectMapper.selectByPrimaryKey(project.getId()) == null) {
                return new ServiceResult(404, Message.project_not_found);
            }
            if (projectMapper.updateByPrimaryKeySelective(project) != 1) {
                return new ServiceResult(405, Message.database_exception);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, project);
    }

    /**
     * 负责查询一条信息点
     *
     * @param id
     * @name selectProject
     * @notice none
     * @author <a href=" ">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult selectProject(Long id) {
        if (id == null) {
            return new ServiceResult(400, Message.parameter_not_enough);
        }
        Project project;
        try {
            project= projectMapper.selectByPrimaryKey(id);
            if (project == null) {
                return new ServiceResult(401, Message.project_not_found);
            }
        }catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, project);
    }

    /**
     * 负责查询专利信息
     *
     * @param page 页数
     * @param pageSize 每页的最多数量
     * @name listProject
     * @notice none
     * @author <a href=" ">郭沛</a>
     * @date 2019-07-26
     */
    @Override
    public ServiceResult listProject(int page, int pageSize) {
        if (page <= 0) {
            return new ServiceResult(400, Message.page_invalid);
        }
        if (pageSize <= 0) {
            return new ServiceResult(401, Message.pageSize_invalid);
        }
        List<Project> projectList;
        try {
            PageHelper.startPage(page, pageSize);
            projectList = projectMapper.listPage(page * pageSize, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            return new ServiceResult(500, Message.please_retry);
        }
        return new ServiceResult(200, Message.success, projectList);
    }

    /**
     * 用于校验数据
     *
     * @return
     * @name validate
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-30
     */
    private String validate(Project project) {
        if (!ValidationUtils.inMaxVarcharSize(project.getTitle())) {
            return Message.title_too_long.toString();
        }if(!ValidationUtils.inMaxTextSize(project.getDescription())){
            return Message.description_too_long.toString();
        } else {
            return null;
        }
    }
}
