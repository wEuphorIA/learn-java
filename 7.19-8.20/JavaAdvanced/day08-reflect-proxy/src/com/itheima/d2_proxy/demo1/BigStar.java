package com.itheima.d2_proxy.demo1;
/*
大明星：提供唱歌和跳舞两个功能
 */
public class BigStar implements Star{
    /**
     * 提供唱歌方法
     */
    public String sing(){
        System.out.println("开始唱歌>>>");
        return "谢谢1";
    }
    /**
     * 提供跳舞方法
     */
    public String dance(){
        System.out.println("开始跳舞>>>闪电五连鞭>>>");
        return "谢谢2";
    }
}
