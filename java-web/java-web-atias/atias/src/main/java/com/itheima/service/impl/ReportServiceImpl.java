package com.itheima.service.impl;

import com.itheima.common.CountOption;
import com.itheima.common.JobOption;
import com.itheima.mapper.EmpMapper;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/3 下午7:27 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption empJobData() {
        List<Map<String, Object>> result = empMapper.empJobData();
        List<Object> pos = result.stream().map(s -> s.get("pos")).toList();
        List<Object> total = result.stream().map(s -> s.get("total")).toList();
        return new JobOption(pos,total);
    }

    @Override
    public List<Map<String, Object>> empGenderData() {
        return empMapper.empGenderData();
    }

    @Override
    public List<Map<String, Object>> studentDegreeData() {
        return studentMapper.studentDegreeData();
    }

    @Override
    public CountOption studentCountData() {
        List<Map<String, Object>> maps = studentMapper.studentCountData();

        List<Object> clazzList = maps.stream().map(s -> s.get("clazzList")).toList();

        List<Object> dataList = maps.stream().map(s -> s.get("dataList")).toList();
        return new CountOption(clazzList,dataList);
    }
}
