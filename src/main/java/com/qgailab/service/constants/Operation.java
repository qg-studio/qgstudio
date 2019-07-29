package com.qgailab.service.constants;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description 操作
 * @date 2019-07-29 08:34
 */
public enum Operation {
    /**
     * 查询
     */
    SELEST("查询"),
    /**
     * 更新
     */
    UPDATE("更新"),
    /**
     * 移除
     */
    REMOVE("删除"),
    /**
     * 插入
     */
    INSERT("插入");
    String name;

    Operation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
