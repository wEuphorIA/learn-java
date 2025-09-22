package com.itheima.d2_generics.demo1;

import java.util.ArrayList;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/9 下午12:15 */
public class MyArrayList<E> {

    private ArrayList<E> list = new ArrayList<>();

    public void add(E e){
        list.add(e);
    }

    public void removed(E e){
        list.remove(e);
    }

    @Override
    public String toString(){
        return list.toString();
    }


}
