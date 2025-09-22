package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.common.PageResult;
import com.itheima.domain.dto.StudentDto;
import com.itheima.domain.pojo.Student;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/3 下午7:32 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper  studentMapper;

    @Override
    public PageResult<Student> getAll(StudentDto studentDto) {

        // 开启分页插件设置参数
        PageHelper.startPage(studentDto.getPage(),studentDto.getPageSize());

        //查询集合
        List<Student> list =  studentMapper.selectAll(studentDto);

        Page<Student> p = (Page<Student>) list;

        return new PageResult<>(p.getTotal(),p.getResult());
    }

    @Override
    public void delete(List<Integer> ids) {
        studentMapper.delete(ids);
    }

    @Override
    public void add(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.addStudent(student);
    }

    @Override
    public Student getById(Integer id) {

        return studentMapper.getById(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void updateCount(Integer id, Short score) {
        Student student = getById(id);
        student.setUpdateTime(LocalDateTime.now());
        student.setViolationScore((short) (student.getViolationScore() + score));
        student.setViolationCount((short) (student.getViolationCount()+1));
        update(student);
    }
}
