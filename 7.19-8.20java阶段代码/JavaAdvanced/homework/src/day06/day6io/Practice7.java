package day06.day6io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/15 下午8:06 */
public class Practice7 {
    private static final String SRC_PATH = "D:\\itheima\\";
    private static final String TAR_PATH = "C:\\Users\\wyk\\Desktop\\code\\JavaAdvanced\\homework\\src\\day06\\day6io\\";

    public static void main(String[] args) throws IOException {
        FileUtils.copyDirectory(new File(SRC_PATH),new File(TAR_PATH + "itheima"));
    }
}

