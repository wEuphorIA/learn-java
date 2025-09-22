package com.itheima.demo8proxy;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/19 下午3:38 */
public class BigStarService implements BigStar{

    private String name;

    public BigStarService(String name) {
        this.name = name;
    }
    @Override
    public void sing(String song) {
        System.out.println(name + "演唱" + song + "歌曲");
    }

    @Override
    public String dance(String dance) {
        System.out.println(name + "跳" + dance + "舞蹈");
        return "谢谢..";
    }
}
