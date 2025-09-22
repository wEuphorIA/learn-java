package com.itheima.d1_file;

import java.io.File;
import java.io.IOException;

/*
目标：File类判断、获取文件信息的方法
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("day06-file-io/src/f-gbk.txt");
        //public boolean exists() 判断当前文件对象，对应的文件路径是否存在，存在返回true
        System.out.println(file.exists());

        //public boolean isFile() 判断当前文件对象指代的是否是文件，是文件返回true，反之返回false
        System.out.println(file.isFile());

        //public boolean isDirectory() 判断当前文件对象指代的是否是文件夹，是文件夹返回true，反之返回false。
        System.out.println(file.isDirectory());

        //public String getName() 获取文件的名称（包含后缀）
        System.out.println(file.getName());

        //public long length() 获取文件的大小，返回字节个数
        System.out.println(file.length());

        //public getAbsolutePath() 获取绝对路径
        System.out.println(file.getAbsolutePath());

        //public boolean createNewFile()：创建一个新文件（文件内容为空），创建成功返回true,反之。
        File file1 = new File("day06-file-io/src/a.txt");
        System.out.println(file1.createNewFile());


        //public boolean mkdir()：用于创建文件夹，注意：只能创建一级文件夹
        File file2 = new File("day06-file-io/src/a/b/c");
        // System.out.println(file2.mkdir());

        //public boolean mkdirs()：用于创建文件夹，注意：可以创建多级文件夹
        File file3 = new File("day06-file-io/src/a");
        // System.out.println(file3.mkdirs());

        //public boolean delete()：删除文件，或者空文件，注意：不能删除非空文件夹。
        System.out.println(file1.delete());
        System.out.println(file3.delete());

        //public File[] listFiles() 获取当前目录下所有的"一级文件对象"到一个文件对象数组中去返回
        File file4 = new File("day06-file-io/src");
        File[] files = file4.listFiles();
        for (File file5 : files) {
            System.out.println(file5);
        }

    }
}
