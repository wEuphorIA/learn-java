package day5Io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/28 下午6:04
 */
public class Practice3 {
    public static void main(String[] args) throws IOException {
        File sourceDir = new File("D:\\itheima");
        File targetDir = new File("C:\\Users\\wyk\\Desktop\\code\\javaSE\\homework\\src\\day5Io\\itheima");
        FileUtils.copyDirectory(sourceDir, targetDir);
    }
}
