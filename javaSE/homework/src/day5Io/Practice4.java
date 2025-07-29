package day5Io;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.io.File;

/**
 * @author Euphoria
 * @version 1.0
 * @description: TODO
 * @date 2025/7/28 下午6:13
 */

public class Practice4 {
    private static final Logger log = LoggerFactory.getLogger(Practice4.class);

    @SneakyThrows
    public static void main(String[] args) {
        String s = FileUtils.readFileToString(new File("C:\\Users\\wyk\\Desktop\\code\\javaSE\\homework\\src\\day5Io\\spring.properties"), "utf-8");
        log.info(s);
    }
}
