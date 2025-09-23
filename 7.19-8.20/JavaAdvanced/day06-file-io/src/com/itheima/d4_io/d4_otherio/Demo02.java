package com.itheima.d4_io.d4_otherio;

import java.io.FileOutputStream;
import java.io.PrintStream;

/*
    目标：掌握打印流：PrintStream/PrintWriter的用法。
    public void println(Xxx xx)	打印任意类型的数据出去
 */
public class Demo02 {
    public static void main(String[] args) throws Exception {
        // PrintWriter printWriter = new PrintWriter(new FileOutputStream("day06-file-io/src/e.txt"));

        PrintStream printWriter = new PrintStream(new FileOutputStream("day06-file-io/src/e.txt"));
        printWriter.println(97);
        printWriter.println(9.2);
        printWriter.println("9.2");
        printWriter.println('a');
        printWriter.println(true);

        printWriter.close();
    }
}
