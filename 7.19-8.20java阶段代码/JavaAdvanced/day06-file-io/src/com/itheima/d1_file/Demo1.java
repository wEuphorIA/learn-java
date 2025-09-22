package com.itheima.d1_file;

import java.io.File;

/*
目标：File类的作用、构造器
    public File (String pathname) 根据文件路径创建文件对象
    public File (String parent, String child) 根据父路径和子路径名字创建文件对象
    public File (File  parent, String child) 根据父路径对应文件对象和子路径名字创建文件对象
 */
public class Demo1 {
    public static void main(String[] args) {
        //public File (String pathname) 根据文件路径创建文件对象
        File file = new File("JavaAdvanced/day06-file-io/src/csb.txt");
        System.out.println(file.getAbsolutePath());

        //public File (String parent, String child) 根据父路径和子路径名字创建文件对象
        File file1 = new File("JavaAdvanced/day06-file-io/src/", "csb.txt");
        System.out.println(file1);

        //public File (File  parent, String child) 根据父路径对应文件对象和子路径名字创建文件对象
        File file2 = new File(new File("JavaAdvanced/day06-file-io/src/"), "csb.txt");
        System.out.println(file2);
    }
}
