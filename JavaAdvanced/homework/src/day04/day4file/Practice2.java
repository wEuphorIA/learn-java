package day4file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/28 下午2:11
 */
public class Practice2 {
    public static void main(String[] args) {
        File file=new File("D:\\itheima");
        File file2 = new File("D:\\itheima\\itheima");
        // 把文件提取出来
        File[] files = file.listFiles(pathname -> pathname.isFile());
        String srcPath ;


        boolean mkdir = file2.mkdir();
        System.out.println(mkdir);
        String path = file2.getPath();
        System.out.println(path);

        for (File file1 : files){
            srcPath = file1.getPath();
            String destPath = file2.getPath() + "\\" + file1.getName();
            try {
                boolean b = copyFile(srcPath, destPath);
                System.out.println(b);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static boolean copyFile(String srcPath, String destPath) throws  IOException{
        // 需求：复制照片。
        // 1、创建一个字节输入流管道与源文件接通
        InputStream is = new FileInputStream(srcPath);
        // 2、创建一个字节输出流管道与目标文件接通。
        OutputStream os = new FileOutputStream(destPath);
        // 3、创建一个字节数组，负责转移字节数据。
        byte[] buffer = new byte[1024]; // 1KB.
        // 4、从字节输入流中读取字节数据，写出去到字节输出流中。读多少写出去多少。
        int len; // 记住每次读取了多少个字节。
        while ((len = is.read(buffer)) != -1){
            os.write(buffer, 0, len);
        }
        os.close();
        is.close();
        System.out.println("复制完成！！");
        return true;
    }
}
