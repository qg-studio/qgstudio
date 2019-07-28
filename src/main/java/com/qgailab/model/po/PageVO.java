package com.qgailab.model.po;

import lombok.Data;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description 一页数据
 * @date 2019-07-28 16:49
 */
@Data
public class PageVO {
    private int page;
    private Object data;

    public PageVO(int page, Object data) {
        this.page = page;
        this.data = data;
    }
}
