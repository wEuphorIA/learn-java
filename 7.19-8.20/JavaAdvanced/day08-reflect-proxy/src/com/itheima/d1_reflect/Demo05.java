package com.itheima.d1_reflect;

import java.util.HashMap;
import java.util.Map;

/**
 * 需求：使用BeanUtils工具类将map集合中的数据按照key封装到一个javabean对象中
 * 第一步：导入commons-beanutils-1.9.3.jar和commons-logging-1.2.jar包
 * 第二步：创建Map集合对象，保存数据，要求Map集合的key要和Student的成员变量名称一致
 * 第三步：创建Student对象
 * 第四步：调用BeanUtils的populate(Object Bean,Map map)方法封装数据到Student对象中
 */
public class Demo05 {
    public static void main(String[] args) throws Exception {
        //第一步：导入commons-beanutils-1.9.3.jar包
        //第二步：创建Map集合对象，保存数据，要求Map集合的key要和Student的成员变量名称一致
        Map<String,Object> map=new HashMap<>();
        map.put("name","张益达");
        map.put("age",22);
        map.put("gender","男");
        //第三步：创建Student对象
        Student student=new Student();
        System.out.println("封装前student = " + student.toString());
        //第四步：调用BeanUtils的populate(Object Bean,Map map)方法封装数据到Student对象中
        //BeanUtils.populate(student,map);
        System.out.println("封装后student = " + student);
    }
}
