package day08.reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/5 下午4:17 */
public class LogUtil {
    private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);

    public static void logMethodStart(String methodName, Object[] args) {
        logger.info("开始调用{}方法，传递的参数有：{}", methodName, Arrays.toString(args));
    }

    public static void logMethodEnd(String methodName, Object result) {
        logger.info("调用{}方法结束，返回的结果是：{}", methodName, result);
    }
}
