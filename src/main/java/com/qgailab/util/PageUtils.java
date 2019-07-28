package com.qgailab.util;

/**
 * @author < a href=" ">郭沛</ a>
 * @description 返回页面数
 * @date 2019-07-28 18:09
 */
public class PageUtils {
    public static int getPage(int count, int pageSize) {
        int page = (int) Math.ceil((float)count /(float) pageSize);
        return page;
    }
}
