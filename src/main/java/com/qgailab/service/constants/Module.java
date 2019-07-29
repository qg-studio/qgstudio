package com.qgailab.service.constants;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description 操作模块
 * @date 2019-07-29 08:34
 */
public enum Module {

    award("奖项"),
    copyright("软著"),
    feature("QG特色"),
    filed("研究方向"),
    history("QG大事记"),
    honor("最近的荣誉"),
    image("首页信息"),
    leader("指导老师"),
    member("成员"),
    moment("重要时刻"),
    news("新闻"),
    patent("专利"),
    project("项目"),
    user("用户");
    String name;

    Module(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
