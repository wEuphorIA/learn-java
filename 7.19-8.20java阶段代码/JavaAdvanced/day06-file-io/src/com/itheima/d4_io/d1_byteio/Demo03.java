package com.itheima.d4_io.d1_byteio;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 目标：掌握文件复制
 * 需求：将硬盘中某个文件复制到当前模块下,文件名保持不变
 */
public class Demo03 {
    public static void main(String[] args) throws Exception {


        FileInputStream in = new FileInputStream("day06-file-io/src/b.txt");

        FileOutputStream out = new FileOutputStream("day06-file-io/src/ab.txt");

        byte[] buffer = new byte[1024];
        int len;

        while ((len = in.read(buffer)) != -1){
            out.write(buffer,0,len);
        }

        in.close();
        out.close();
    }
}
