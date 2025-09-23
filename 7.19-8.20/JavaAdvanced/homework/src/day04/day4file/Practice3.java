package day4file;

import java.io.*;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/28 下午4:48
 */
public class Practice3 {
    public static void main(String[] args) {
        File file=new File("D:\\itheima");
        File file2 = new File("D:\\itheima\\itheima");

        if (!file2.exists() && !file2.mkdirs()) {
            System.out.println("创建失败");
        }
        // 把文件提取出来
        File[] files = file.listFiles(pathname -> pathname.isFile());

        for (File file1 : files){
            String srcPath = file1.getPath();
            String destPath = file2.getPath() + "\\" + file1.getName();
            try {
                boolean b = copyFile(srcPath, destPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            copyDirectory(file,file2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static boolean copyFile(String srcPath, String destPath) throws IOException {
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

    public static void copyDirectory(File sourceFile,File destFile) throws IOException {

        if (!destFile.exists() && !destFile.mkdirs()) {
            throw new IOException("无法创建目标目录");
        }

        File[] children = sourceFile.listFiles();
        if (children != null) {
            for (File child : children) {
                if (child.getCanonicalPath().equals(destFile.getCanonicalPath())) {
                    continue;
                }
                File destChild = new File(destFile, child.getName());
                if (child.isFile()) {
                    copyFile(child.getPath(), destChild.getPath());
                } else if (child.isDirectory()) {
                    copyDirectory(child, destChild); // 递归处理子目录
                }
            }
        }
    }
}
