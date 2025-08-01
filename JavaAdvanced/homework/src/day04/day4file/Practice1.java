package day4file;

import java.io.File;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/28 上午10:49
 */
public class Practice1 {
    public static void main(String[] args) {
        File file=new File("D:\\itheima");

        if (!file.exists()){
            boolean mkdir = file.mkdir();
            System.out.println(mkdir);
        }else {
            //
            System.out.println("itheima已存在");
        }

        System.out.println(getFileSize(file));

    }

    public static Long getFileSize(File dir){
        long size = 0;
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()){
                    size += file.length(); // 累加文件大小
                }else {
                    size += getFileSize(file); // 递归处理子目录
                }

            }
        }
        return size;
    }
}
