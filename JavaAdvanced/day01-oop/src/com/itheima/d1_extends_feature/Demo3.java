package com.itheima.d1_extends_feature;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/3 下午5:21 */
public class Demo3 {
    public static void main(String[] args) {
        D d = new D();
        d.show();
    }
}
class C {
    public String name = "C";

    public void call(){
        System.out.println("c叫");
    }

}
class D extends C{
    public String name = "D1";
    public void show(){
        String name = "D2";
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);

        call();
        super.call();
    }
    public void call(){
        System.out.println("d叫");
    }
}
