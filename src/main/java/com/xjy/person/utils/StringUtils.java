package com.xjy.person.utils;

/**
 * String常量工具类.
 * Created by blinkfox on 2017/4/5.
 */
public final class StringUtils {

    /**
     * 私有构造方法.
     */
    private StringUtils() {
        super();
    }

    /**
     * 快速连接参数中的字符串.
     * @param strs 各字符串参数
     * @return 连接后的字符串
     */
    public static String concat(String ... strs) {
        StringBuilder sb = new StringBuilder("");
        for (String str: strs) {
            sb.append(str);
        }
        return sb.toString();
    }

}