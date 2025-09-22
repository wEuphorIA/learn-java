package com.itheima.d2_generics.demo4;

import java.util.ArrayList;

/*
    目标：演示泛型通配符、上下限
    通配符: 就是 “?” ，可以在“使用泛型”的时候代表一切类型；  E T K V 是在定义泛型的时候使用。
    泛型上限: ? extends Car:   ? 能接收的必须是Car或者其子类。
    泛型下限：? super Car ： ?  能接收的必须是Car或者其父类。

 */
public class Demo {
    public static void main(String[] args) {

        ArrayList<XiaoMi> xmList = new ArrayList<>();
        xmList.add(new XiaoMi());
        go(xmList);

        ArrayList<LiXiang> lxList = new ArrayList<>();
        lxList.add(new LiXiang());
        go(lxList);

        ArrayList<BYD> bydList = new ArrayList<>();
        bydList.add(new BYD());
        go(bydList);

    }

    // 让任何车队都能跑
    // 通配符: 就是 “?”,可以在“使用泛型”的时候代表一切类型:E T K V 是在定义泛型的时候使用。
    // 泛型上限: ? extends Car:   ? 能接收的必须是Car或者其子类。
    // 泛型下限：? super Car:     ? 能接收的必须是Car或者其父类。
    public static void go(ArrayList<? extends Car> list) {

    }
}
