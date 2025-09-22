package com.itheima.d2_recursion;

import java.io.File;
import java.io.IOException;

/*
需求：在D:\\判断下搜索QQ.exe这个文件，然后直接输出。
分析：
    1. 先找出D:盘下的所有一级文件对象
    2. 遍历全部一级文件对象，判断是否是文件
    3. 如果是文件，判断是否是自己想要的
    4. 如果是文件夹，需要继续进入到该文件夹，重复上述过程
 */
public class Demo4 {
    private static final String PATH = "D:\\qq\\";
    private static final String FILE_NAME = "QQ.exe";
    public static void main(String[] args) throws IOException {
        File file = new File(PATH);
        fileFind(file, FILE_NAME);
    }

    private static void fileFind(File file, String fileName) throws IOException {
        if (!file.exists()||!file.isDirectory()||file.listFiles()==null) {
            return;
        }
        File[] files = file.listFiles();
        if (files ==  null){
            return;
        }
        for (File f : files) {
            //判断是否是文件
            if (f.isFile()) {
                if (f.getName().equals(fileName)) {
                    System.out.println(f);
                    Runtime runtime = Runtime.getRuntime();
                    runtime.exec(f.getAbsolutePath());
                }
            }else {
                fileFind(f, fileName);
            }
        }
    }
}
