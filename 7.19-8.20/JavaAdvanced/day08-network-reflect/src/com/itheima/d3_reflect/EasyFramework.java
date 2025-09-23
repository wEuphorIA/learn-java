package com.itheima.d3_reflect;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Field;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/19 上午10:29 */
public class EasyFramework {
    public static void save(Object object) throws  Exception{
        FileWriter writer = new FileWriter("day08-network-reflect/src/out.txt",true);
        PrintWriter pw = new PrintWriter(writer,true);
        Class cls = object.getClass();
        pw.println("---------------"+cls.getSimpleName()+"------------------------");
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {

            field.setAccessible(true);
            pw.println(field.getName() + "=" + field.get(object));
        }
        pw.close();
    }
}
