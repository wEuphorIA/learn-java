package com.itheima.service;

import com.itheima.domain.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    void removeById(Integer id);

    void addDept(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
