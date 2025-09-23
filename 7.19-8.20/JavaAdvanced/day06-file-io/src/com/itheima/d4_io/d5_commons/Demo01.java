package com.itheima.d4_io.d5_commons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

//目标：掌握在程序中导入commons-io简化io功能实现
public class Demo01 {
    public static void main(String[] args) throws IOException {
        /*
          commons-io是apache开源基金组织提供的一组有关IO操作的类库，可以提高IO功能开发的效率
          commons-io工具包提供了很多有关io操作的类。有两个主要的类FileUtils, IOUtils
          <p>
          FileUtils提供的部分方法：
               String readFileToString(File file, String encoding)：读取文件中的数据, 返回字符串
               void copyFile(File srcFile, File destFile)：复制文件
               void copyDirectory(File srcDir, File destDir)：复制文件夹
          IOUtils类提供的部分方法：
               public static int copy(Inputstream inputStream, Outputstream outputStream) 复制文件。
               public static int copy(Reader reader, Writer writer) 复制文件。
          需求：使用commons-io简化io流读写
         */
        System.out.println(FileUtils.readFileToString(new File("day06-file-io/src/csb.txt"), "UTF-8"));
        FileUtils.copyFile(new File("day06-file-io/src/csb.txt"),new File("day06-file-io/src/csb_new1.txt"));
        FileUtils.delete(new File("day06-file-io/src/csb_new1.txt"));

    }
}
