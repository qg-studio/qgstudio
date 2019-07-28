package com.qgailab.service;

import com.qgailab.model.dto.ServiceResult;
import com.qgailab.model.po.History;
import org.springframework.stereotype.Service;

@Service
public interface HistoryService {

    /**插入QG历史
     * @name insertHistory
     * @param  history
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult insertHistory(History history);

    /**
     * 移除QG历史
     * @name removeHistory
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult removeHistory(Long id);

    /**
     * 更新QG历史
     * @name updateHistory
     * @param  history
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult updateHistory(History history);

    /**
     * 查询单个QG历史
     * @name selectHistory
     * @param  id
     * @return ServiceResult
     * @notice none
     * @author < a href=" ">郭沛</ a>
     * @date
     */
    ServiceResult selectHistory(Long id);

    /**
     * 返回信息点
     *
     * @param page  页数
     * @param pageSize 一页最大记录数
     * @name listHistory
     * @notice none
     * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
     * @date 2019-07-26
     */
    ServiceResult listHistory(int page, int pageSize);
}
