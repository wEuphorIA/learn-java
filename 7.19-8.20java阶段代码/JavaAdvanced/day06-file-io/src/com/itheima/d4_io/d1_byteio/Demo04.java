package com.itheima.d4_io.d1_byteio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
         目标：掌握资源释放的两种方式：
         方式一：掌握try-catch-finally资源释放的使用
         try{
         ...
         }catch(Exception){
         <p>
         }finally{
         <p>
         }
         finally：放在try-catch后面的，无论是正常执行还是异常执行代码，最后一定要执行，除非JVM退出。
         作用：一般用于进行最后的资源释放操作（专业级做法）
         方式二：掌握try-with-resource资源释放的使用
         try(创建资源对象){
         ...
         }catch(Exception){
         <p>
         }
         JDK7改进方案：在try后加上小括号，在其内定义流对象，即可自动释放
         注意：资源都是实现了Closeable/AutoCloseable接口的类对象
         需求：硬盘中某个文件复制到当前模块下,文件名保持不变，使用上述两种方式释放资源
 */
public class Demo04 {
    public static void main(String[] args) {
        // copy1();
        copy2();

    }

    private static void copy2() {

        try (
                FileInputStream in = new FileInputStream("day06-file-io/src/b.txt");
                FileOutputStream out = new FileOutputStream("day06-file-io/src/ab.txt");
                //需要实现Closeable 或者 AutoCloseable
                Myconnectional myconnectional = new Myconnectional()
        ) {

            byte[] buffer = new byte[1024];
            int len;

            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void copy1() {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("day06-file-io/src/b.txt");

            out = new FileOutputStream("day06-file-io/src/ab.txt");


            byte[] buffer = new byte[1024];
            int len;

            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Myconnectional implements AutoCloseable{

    @Override
    public void close() throws Exception {
        System.out.println("自定义的流关闭了");
    }
}


