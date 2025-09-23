package com.itheima.d3_reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 目标1：掌握利用反射获取构造器Constructor对象
 需求：利用反射获取Student类的构造器对象，并利用构造器对象创建Student对象
 获取构造器的方法：
 Constructor<?>[] getConstructors()：返回所有构造器对象的数组（只能拿public的）
 Constructor<?>[] getDeclaredConstructors()：返回所有构造器对象的数组，存在就能拿到
 Constructor<T> getConstructor(Class<?>... parameterTypes)：返回单个构造器对象（只能拿public的）
 Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)：返回单个构造器对象，存在就能拿到
 <p>
 创建对象的方法：
 T newInstance(Object... initargs)：根据指定的构造器创建对象
 void setAccessible(boolean flag)：设置为true,表示取消访问检查，进行暴力反射
 扩展：  使用Class对象实例化对象
 T newInstance(): 调用无参数构造方法实例化对象
 <p>
 目标2：掌握利用反射获取成员变量Field对象
 需求：获取Student类中的各个属性Field对象，并给属性赋值、获取属性的值
 获取成员变量的方法：
 Field[] getFields()：返回所有成员变量对象的数组（只能拿public的）
 Field[] getDeclaredFields()：返回所有成员变量对象的数组，存在就能拿到
 Field getField(String name)：返回单个成员变量对象（只能拿public的）
 Field getDeclaredField(String name)：返回单个成员变量对象，存在就能拿到
 <p>
 Field类中用于取值、赋值的方法：
 void set(Object obj, Object value)：赋值
 Object get(Object obj)：获取值
 <p>
 目标3：掌握利用反射获取方法Method对象
 需求：获取Student类中的各个方法Method对象，并且调用方法
 获取成员方法的api：
 Method[] getMethods()：返回所有成员方法对象的数组（只能拿public的）
 Method[] getDeclaredMethods()：返回所有成员方法对象的数组，存在就能拿到
 Method getMethod(String name, Class<?>... parameterTypes)：返回单个成员方法对象（只能拿public的）
 Method getDeclaredMethod(String name, Class<?>... parameterTypes)：返回单个成员方法对象，存在就能拿到
 <p>
 触发执行的方法：
 Object invoke(Object obj, Object... args)
 运行方法
 参数一：用obj对象调用该方法
 参数二：调用方法的传递的参数（如果没有就不写）
 返回值：方法的返回值（如果没有就不写）
 */
public class Demo02 {

    @Test
    public void test1() throws Exception {
        Class<Student> cla1 = Student.class;
        Constructor<?>[] constructors = cla1.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName() +"("+constructor.getParameterCount() + ")" );
        }

        Constructor<Student> constructor = cla1.getDeclaredConstructor(String.class);
        Student s = constructor.newInstance("张三");
        System.out.println(s);

        Constructor constructors1 = cla1.getDeclaredConstructor();
        constructors1.setAccessible(true);
        Student s1 = (Student) constructors1.newInstance();

        System.out.println(s1);

    }
    @Test
    public void test2() throws Exception {
        Class<Student> cla1 = Student.class;
        Field[] fields = cla1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        Field field = cla1.getDeclaredField("name");
        field.setAccessible(true);
        Student student = new Student("张三", 18);
        field.set(student,"李四");
        System.out.println(student);
    }

    @Test
    public void test3() throws Exception {
        Class<Student> cla1 = Student.class;
        Method[] methods = cla1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + "("+method.getParameterCount() + ")");
        }
        Method method = cla1.getDeclaredMethod("setName", String.class);
        Student student = new Student("张三", 18);
        method.invoke(student, "李四");
        System.out.println(student);

        Method method1 = cla1.getDeclaredMethod("show");
        method1.setAccessible(true);
        method1.invoke(student);


    }

}
