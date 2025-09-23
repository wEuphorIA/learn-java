package com.itheima.d1_extends_construct;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/4 上午9:15 */
public class Demo1 {
    public static void main(String[] args) {
        //特点：子类对象创建时，会默认调用父类的无参构造方法
        Zi zi = new Zi();

    }
}
class Fu{
    private Fu(){
        System.out.println("父类无参构造方法");
    }
    public Fu(int a){
        System.out.println("父类有参构造方法");
    }

}
class Zi extends Fu{
    public Zi(){
        /*
        默认调用父类的无参构造方法,写不写都存在,
        super();
        */
        super(2);//还可以调用父类的有参构造方法
        System.out.println("子类无参构造方法");
    }
}
