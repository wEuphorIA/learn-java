package com.itheima.d1_file;

import java.io.File;
import java.util.Arrays;

/*
    目标：掌握File提供的遍历文件夹的方法。

    public File[] listFiles()	获取当前目录下所有的"一级文件对象"到一个文件对象数组中去返回（重点）
    使用listFiles方法时的注意事项：
        1 当主调是文件，或者路径不存在时，返回null
        2 当主调是空文件夹时，返回一个长度为0的数组
        3 当主调是一个有内容的文件夹时，将里面所有一级文件和文件夹的路径放在File数组中返回
        4 当主调是一个文件夹，且里面有隐藏文件时，将里面所有文件和文件夹的路径放在File数组中返回，包含隐藏文件
        5 当主调是一个文件夹，但是没有权限访问该文件夹时，返回null

 */
public class Demo3 {
    public static void main(String[] args) {
    }
}











