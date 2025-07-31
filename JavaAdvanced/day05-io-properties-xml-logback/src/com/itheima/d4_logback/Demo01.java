package com.itheima.d4_logback;

//目标：掌握在项目中导入Logback日志技术并使用
/**
 * 需求：利用logback日志技术，将日志信息打印在控制台
 * Logback日志技术导入步骤：
 *      1.将资料中lib目录下的logback相关jar包复制到模块中，并add as library 添加为模块依赖
 *      2.创建Logback框架提供的Logger对象，然后用Logger对象调用其提供的方法就可以记录运行的日志信息了
 *          Logger log=loggerFactory.getLogger(类.class);
 *          Log.info("main方法开始执行");
 *          Log.info("天王盖地虎，小鸡炖蘑菇");
 *          Log.info("main方法执行结束");
 * 注意：如果项目中引入了lombok工具包，可以在类上使用@Slf4j注解，idea在编译阶段可以为我们自动生成log对象。
 */
public class Demo01 {
    public static void main(String[] args) {

    }
}
