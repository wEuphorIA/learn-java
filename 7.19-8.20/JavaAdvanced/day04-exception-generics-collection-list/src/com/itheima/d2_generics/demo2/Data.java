package com.itheima.d2_generics.demo2;

public interface Data<E> {

    void add(E e);

    void remove(E e);

    void update(E e);

    E query(int id);

}
