package day06.day6io;

import java.io.File;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/13 下午8:10 */
//删除非空文件
public class Practice3 {
    private static final String PATH = "D:\\itheima1\\";

    public static void main(String[] args) {
        File file = new File(PATH);
        delete(file);
    }
    private static void delete(File file) {
        if (!file.exists() || !file.isDirectory() || file.listFiles() == null) {
            return;
        }
        File[] files = file.listFiles();
        if (files==null){
            return;
        }
        for (File f : files) {
            if (f.isFile()){
                f.delete();
            }
            if (f.isDirectory()){
                delete(f);
                f.delete();
            }
        }
        file.delete();
        System.out.println("删除完毕");
    }
}
