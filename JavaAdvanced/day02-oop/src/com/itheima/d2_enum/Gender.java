package com.itheima.d2_enum;

/*
    枚举：一种特殊类
    语法：
        public enum 枚举类名{
            //第一句定义若干个名称表示枚举对象，也是常量；
            //从第二句开始可以定义成员(成员变量、成员方法、构造器)
        }
    注意实现：
        1 枚举类的第一句只能罗列一些名称，这些名称都是常量，并且每个常量会记住枚举类的一个对象。
        2 枚举类中，从第二句(行)开始，可以定义类的其他各种成员(成员变量、成员方法、构造器)。
        3 枚举都是最终类，不可以被继承，枚举类都是继承java.lang.Enum类的。
        4 枚举类的构造器都是私有的（写不写都只能是私有的），因此，枚举类对外不能创建对象。
        5 编译器为枚举类新增了几个静态方法，用于获取所有枚举对象或者某个枚举对象。
 */
public enum Gender{
    //1 枚举类的第一句只能罗列一些名称，这些名称都是常量，并且每个常量会记住枚举类的一个对象。
    MAN,  //等价于：public static final Gender MAN = new Gender();，默认是基于空参构造创建
    WOMAN("女"); //等价于：public static final Gender WOMAN = new Gender("女");

    // 2 枚举类中，从第二句(行)开始，可以定义类的其他各种成员(成员变量、成员方法、构造器)。
    //    public Gender(){} //报错
    private Gender(){}
    //有参构造
    Gender(String value) {
        this.value = value;
    }

    //成员变量
    private String value;  //MAN和WOMAN对象中都会有value属性

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
