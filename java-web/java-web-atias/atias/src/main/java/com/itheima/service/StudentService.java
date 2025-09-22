package com.itheima.service;

import com.itheima.common.PageResult;
import com.itheima.domain.dto.StudentDto;
import com.itheima.domain.pojo.Student;

import java.util.List;

public interface StudentService {
    PageResult<Student> getAll(StudentDto studentDto);

    void delete(List<Integer> ids);

    void add(Student student);

    Student getById(Integer id);

    void update(Student student);

    void updateCount(Integer id, Short score);
}
