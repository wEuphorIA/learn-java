package day05.day5Io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/28 下午5:50
 */
public class Practice2 {
    public static void main(String[] args) throws IOException {
        File sourceDir = new File("D:\\itheima");
        File targetDir = new File("D:\\itheima\\itheima");

        // 1. 确保目标目录存在
        if (!targetDir.exists()) {
            boolean created = targetDir.mkdirs();
            if (!created) {
                System.out.println("无法创建目录: " + targetDir);
            }
        }
        // 2. 获取第一个文件
        File[] files = sourceDir.listFiles(File::isFile);

        File sourceFile = files[0];

        // 3. 执行复制
        File targetFile = new File(targetDir, sourceFile.getName());
        FileUtils.copyFile(sourceFile, targetFile);
        System.out.println("已复制: " + sourceFile.getName() + " -> " + targetFile);

    }
}
