package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.excel.model.StudentModel;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService extends IService<Student> {
    /**
     * 导入学生信息
     */
    void importStudent(List<StudentModel> cachedDataList, Integer clazzId);

    /**
     * 查询学生信息
     */
    List<StudentModel> list(String name, Integer degree, Integer clazzId);

    PageResult<Student> pageStudent(IPage<Student> page, StudentQueryParam param);
}
