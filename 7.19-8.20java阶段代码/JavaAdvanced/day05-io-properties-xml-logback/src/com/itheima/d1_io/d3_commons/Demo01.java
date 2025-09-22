package com.itheima.d1_io.d3_commons;

import java.io.IOException;

//目标：掌握在程序中导入commons-io简化io功能实现
public class Demo01 {
    public static void main(String[] args) throws IOException {
        /**
         * commons-io是apache开源基金组织提供的一组有关IO操作的类库，可以提高IO功能开发的效率
         * commons-io工具包提供了很多有关io操作的类。有两个主要的类FileUtils, IOUtils
         *
         * FileUtils提供的部分方法：
         *      String readFileToString(File file, String encoding)：读取文件中的数据, 返回字符串
         *      void copyFile(File srcFile, File destFile)：复制文件
         *      void copyDirectory(File srcDir, File destDir)：复制文件夹
         * IOUtils类提供的部分方法：
         *      public static int copy(Inputstream inputStream, Outputstream outputStream) 复制文件。
         *      public static int copy(Reader reader, Writer writer) 复制文件。
         * 需求：使用commons-io简化io流读写
         */


    }
}
