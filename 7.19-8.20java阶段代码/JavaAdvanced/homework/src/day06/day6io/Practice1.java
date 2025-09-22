package day06.day6io;

import java.io.File;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/13 下午7:56 */
public class Practice1 {
    private static final String PATH = "D:\\itheima\\";

    public static void main(String[] args) {
        File file = new File(PATH);
        if (!file.exists()) {
            file.mkdir();
        }
        System.out.println("这个文件夹中的大小为 = " + totalSize(file));

    }

    private static long totalSize(File file) {
        if (!file.exists() || !file.isDirectory() || file.listFiles() == null) {
            return -1;
        }
        long sum = 0L;
        File[] files = file.listFiles();
        if (files == null) {
            return -1;
        }
        for (File f : files) {
            if (f.isFile()) {
                sum += f.length();
            }
            if (f.isDirectory()){
                long l = totalSize(f);
                sum += l;
            }
        }
       return sum;
    }
}
