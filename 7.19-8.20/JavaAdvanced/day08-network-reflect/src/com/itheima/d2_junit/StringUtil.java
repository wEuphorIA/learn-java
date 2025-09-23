package com.itheima.d2_junit;

/**
 * 字符串工具类
 */
public class StringUtil {
    /**
     * 获取名字的长度
     * @param name
     */
    public static void printNumber(String name) {
        if (name == null || name.isEmpty()){
            System.out.println("不能为空或者为空字符串");
            return;
        }
        System.out.println("名字长度是：" + name.length());
    }

    /**
     * 求字符串的最大索引
     */
    public static int getMaxIndex(String data) {
        if (data == null) {
            return -1;
        }
        if (data.isEmpty()){
            return 0;
        }
        return data.length() ;
    }
}