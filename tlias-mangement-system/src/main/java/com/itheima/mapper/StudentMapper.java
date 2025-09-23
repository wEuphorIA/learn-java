package com.itheima.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 批量保存学员信息
     */
    void insertBatch(List<Student> cachedDataList);

    List<Student> list(String name, Integer degree, Integer clazzId);

    Page<Student> pageStudent(IPage<Student> page, StudentQueryParam param);
}
