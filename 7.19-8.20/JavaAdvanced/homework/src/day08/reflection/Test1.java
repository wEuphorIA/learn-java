package day08.reflection;

import java.nio.file.Paths;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/5 下午4:08 */
public class Test1 {
    public static void main(String[] args) {
        Teacher t = new Teacher("王老师", 23, "生物学");
        // 使用反射将对象属性写入文件
        ReflectionUtil.writeObjectToFile(t,  "C:\\Users\\wyk\\Desktop\\code\\JavaAdvanced\\homework\\src\\day08\\reflection.obj.txt");

        System.out.println("对象属性已成功写入obj.txt文件");
    }
}
