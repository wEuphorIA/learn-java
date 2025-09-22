package day08.reflection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/5 下午4:06 */
public class ReflectionUtil {
    public static void writeObjectToFile(Object obj, String filename) {
        Class<?> clazz = obj.getClass();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // 写入类名
            writer.write("========" + clazz.getSimpleName() + "========");
            writer.newLine();

            // 获取所有字段（包括私有字段）
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true); // 设置可访问私有字段
                String fieldName = field.getName();
                Object fieldValue = field.get(obj);

                // 写入属性名和属性值
                writer.write(fieldName + " = " + fieldValue);
                writer.newLine();
            }

            writer.newLine(); // 添加空行分隔
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
