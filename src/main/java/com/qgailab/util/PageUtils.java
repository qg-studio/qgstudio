package com.qgailab.util;

/**
 * @description 返回页面数
 * @author < a href=" ">郭沛</ a>
 * @date 2019-07-28 18:09
 */
public class PageUtils {
    public static int getPage(int count, int pageSize) {
      return (int) Math.ceil(count / pageSize);
    }
}
