package com.qgailab.service.constants;

/**
 * @author <a href="mailto:kobe524348@gmail.com">黄钰朝</a>
 * @description
 * @date 2019-07-26 08:39
 */
public enum Message {

    /*
     **************************************************************
     *              用户
     **************************************************************
     */
    /**
     * 密码错误
     */
    password_incorrect(""),
    /**
     * 用户不存在
     */
    account_not_found,

    /*
     **************************************************************
     *              荣誉
     **************************************************************
     */
    /**
     * 专利不存在
     */
    patent_not_found,

    /**
     * 著作权不存在
     */
    copyright_not_found,
    /**
     * 最近荣誉不存在
     */
    honor_not_found,
    /**
     * 新闻链接不存在
     */
    news_not_found,

    /*
     **************************************************************
     *              关于QG
     **************************************************************
     */

    intro_not_found,
    /**
     * QG历史不存在
     */
    history_not_found,

    /*
     **************************************************************
     *              我们
     **************************************************************
     */

    /**
     * 指导老师不存在
     */
    leader_not_found,

    /**
     * 重要时刻不存在
     */
    moment_not_found,
    /**
     * 奖项不存在
     */
    award_not_found,
    /**
     * 特色不存在
     */
    feature_not_found,
    /*
     **************************************************************
     *              成员
     **************************************************************
     */
    /**
     * 成员不存在
     */
    member_not_found,

    /*
     **************************************************************
     *              项目
     **************************************************************
     */
    /**
     * 项目不存在
     */
    project_not_found,


    /*
     **************************************************************
     *              专栏
     **************************************************************
     */
    /**
     * 领域不存在
     */
    field_not_found,

    /*
     **************************************************************
     *              系统
     **************************************************************
     */
    /**
     * 标题过长
     */
    title_too_long,
    /**
     * 描述过长
     */
    description_too_long,
    /**
     * 名称过长
     */
    name_too_long,
    /**
     * 序号太长
     */
    number_too_long,
    /**
     * 登记号太长
     */
    rn_too_long,
    /**
     * 身份太长
     */
    position_too_long,
    /**
     * 年级太长
     */
    grade_too_long,
    /**
     * 研究方向太长
     */
    field_too_long,
    /**
     * url太长
     */
    url_too_long,
    /**
     * 发明专利太长
     */
    zl_too_long,
    /**
     * 发明人太长
     */
    inventor_too_long,
    /**
     * 项目太长
     */
    project_too_long,
    /**
     * 比赛太长
     */
    game_too_long,
    /**
     * 比赛等级太长
     */
    level_too_long,
    /**
     * 指导老师太长
     */
    leader_too_long,
    /**
     * 颁奖机构过长
     */
    institution_too_long,
    /**
     * 奖项太长
     */
    prize_too_long,
    /**
     * 获奖学生太长
     */
    winner_too_long,


    /**
     *
     */
    /**
     * 图片不存在
     */
    image_not_found,
    /**
     * 图片已丢失
     */
    image_has_lost,
    /**
     * 页的大小不能小于零
     */
    pageSize_invalid,

    /**
     * 页数不合法
     */
    page_invalid,

    /**
     * 图片不可为空
     */

    image_not_null,
    /**
     * 文件名不可为空
     */
    filename_not_null,

    /**
     * 标题不可为空
     */
    title_not_null,
    /**
     * 成功
     */
    success,
    /**
     * 未知错误，请重试
     */
    please_retry,
    /**
     * 数据库出错
     */
    database_exception,
    /**
     * 参数不足
     */
    parameter_not_enough,
    /**
     * url不能为空
     */
    url_not_null,
    /**
     * 描述不能为空
     */
    description_not_null,
    /**
     * excel不能为空
     */
    excel_not_null,
    /**
     * 不支持的格式
     */
    type_not_support,
    /**
     * 名称不能为空
     */
    name_not_null,
    /**
     * 没有对应的属性
     */
    attribute_not_found,
    /**
     * 某些格式不支持
     */
    something_unsupported,
    /**
     * 没有相关的对象
     */
    object_not_found;

    String message;

    Message(String message) {
        this.message = message;
    }

    /**
     * Returns the name of this enum constant, as contained in the
     * declaration.  This method may be overridden, though it typically
     * isn't necessary or desirable.  An enum type should override this
     * method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant
     */
    @Override
    public String toString() {
        return this.message;
    }
}
