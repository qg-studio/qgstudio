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
    password_incorrect("密码错误"),
    /**
     * 用户不存在
     */
    account_not_found("该账户不存在"),
    /**
     * 用户名格式不对
     */
    username_invalid("用户名格式不正确"),

    /*
     **************************************************************
     *              荣誉
     **************************************************************
     */
    /**
     * 专利不存在
     */
    patent_not_found("该专利不存在"),

    /**
     * 著作权不存在
     */
    copyright_not_found("该软件著作权不存在"),
    /**
     * 最近荣誉不存在
     */
    honor_not_found("该最近的荣誉不存在"),
    /**
     * 新闻链接不存在
     */
    news_not_found("该新闻链接不存在"),

    /*
     **************************************************************
     *              关于QG
     **************************************************************
     */

    intro_not_found("该首页信息不存在"),
    /**
     * QG历史不存在
     */
    history_not_found("该QG大事记不存在"),

    /*
     **************************************************************
     *              我们
     **************************************************************
     */

    /**
     * 指导老师不存在
     */
    leader_not_found("该指导老师不存在"),

    /**
     * 重要时刻不存在
     */
    moment_not_found("该重要时刻不存在"),
    /**
     * 奖项不存在
     */
    award_not_found("该奖项不存在"),
    /**
     * 特色不存在
     */
    feature_not_found("该QG特色不存在"),
    /*
     **************************************************************
     *              成员
     **************************************************************
     */
    /**
     * 成员不存在
     */
    member_not_found("该成员不存在"),

    /*
     **************************************************************
     *              项目
     **************************************************************
     */
    /**
     * 项目不存在
     */
    project_not_found("该项目不存在"),


    /*
     **************************************************************
     *              专栏
     **************************************************************
     */
    /**
     * 领域不存在
     */
    field_not_found("该研究方向不存在"),

    /*
     **************************************************************
     *              系统
     **************************************************************
     */
    /**
     * 标题过长
     */
    title_too_long("您输入的标题过长"),
    /**
     * 日期过长
     */
    date_too_long("您输入的日期过长"),
    /**
     * 类型过长
     */
    type_too_long("您输入的类型过长"),
    /**
     * 描述过长
     */
    description_too_long("您输入的描述过长"),
    /**
     * 名称过长
     */
    name_too_long("您输入的名称过长"),
    /**
     * 序号太长
     */
    number_too_long("您输入的序号过长"),
    /**
     * 登记号太长
     */
    rn_too_long("您输入的登记号过长"),
    /**
     * 身份太长
     */
    position_too_long("您输入的身份信息过长"),
    /**
     * 年级太长
     */
    grade_too_long("您输入的年级过长"),
    /**
     * 研究方向太长
     */
    field_too_long("您输入的研究方向过长"),
    /**
     * url太长
     */
    url_too_long("您填写的url过长！"),
    /**
     * 发明专利太长
     */
    zl_too_long("您填写的专利号不符合专利规范！"),
    /**
     * 发明人太长
     */
    inventor_too_long("您填写的发明人不符合规范！"),
    /**
     * 项目太长
     */
    project_too_long("您填写的项目名过长！"),
    /**
     * 比赛太长
     */
    game_too_long("您填写的比赛名过长！"),
    /**
     * 比赛等级太长
     */
    level_too_long("您填写的比赛等级过长！"),
    /**
     * 指导老师太长
     */
    leader_too_long("您填写的指导老师名过长！"),
    /**
     * 颁奖机构过长
     */
    institution_too_long("您填写的颁奖机构名过长！"),
    /**
     * 奖项太长
     */
    prize_too_long("您填写的奖项名过长！"),
    /**
     * 获奖学生太长
     */
    winner_too_long("您填写的获奖学生人数过多！"),
   /**
     *
     */
    /**
     * 图片不存在
     */
    image_not_found("您查看的图片不存在！"),
    /**
     * 图片已丢失
     */
    image_has_lost("您查看的图片已丢失！"),
    /**
     * 页的大小不能小于零
     */
    pageSize_invalid("您填写的数据量不能小于0！"),

    /**
     * 页数不合法
     */
    page_invalid("您填写的页数不符合规范！"),

    /**
     * 图片不可为空
     */
    image_not_null("您上传的图片不能为空！"),
    /**
     * 文件名不可为空
     */
    filename_not_null("您的文件名不能为空！"),
    /**
     * 类型不能为空
     */
    type_not_null("您上传的Excel文件中type不能为空！"),
    /**
     * 类型不能为空
     */
    project_not_null("您上传的Excel文件中project不能为空！"),
    /**
     * 整行为空
     */
    row_null("整行数据为空！"),
    /**
     * 著作权不能为空
     */
    rn_not_null("您上传的Excel文件中rn不能为空！"),
    /**
     * 标题不可为空
     */
    title_not_null("您的标题不能为空！"),
    /**
     * 成功
     */
    success("您的请求成功！"),
    /**
     * 未知错误，请重试
     */
    please_retry("未知错误，请重试！"),
    /**
     * 数据库出错
     */
    database_exception("数据库出现错误！"),
    /**
     * 参数不足
     */
    parameter_not_enough("您填写的参数不足！"),
    /**
     * url不能为空
     */
    url_not_null("您填写的url不能为空！"),
    /**
     * 描述不能为空
     */
    description_not_null("您的描述不能为空！"),
    /**
     * excel不能为空
     */
    excel_not_null("您要导入的文件不能为空！"),
    /**
     * 不支持的格式
     */
    type_not_support("不支持的格式错误！"),
    /**
     * 名称不能为空
     */
    name_not_null("您的名称不能为空！"),
    /**
     * 没有对应的属性
     */
    attribute_not_found("没有找到对应的属性！"),
    /**
     * 某些格式不支持
     */
    something_unsupported("某些格式不支持！"),
    /**
     * 没有相关的对象
     */
    object_not_found("没有找到相关的对象！");

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
