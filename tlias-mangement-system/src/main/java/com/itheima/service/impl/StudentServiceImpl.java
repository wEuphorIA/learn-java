package com.itheima.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.excel.model.StudentModel;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void importStudent(List<StudentModel> cachedDataList, Integer clazzId) {

        log.info("学生信息导入开始, 共{}条", cachedDataList.size());
        if(!cachedDataList.isEmpty()){
            List<Student> studentList = cachedDataList.stream().map(sm -> {
                Student student = BeanUtil.copyProperties(sm, Student.class);
                student.setGender(sm.getGenderStr().equals("男") ? 1 : 2);
                student.setIsCollege(sm.getIsCollegeStr().equals("是") ? 1 : 0);
                switch (sm.getDegreeStr()) {
                    case "初中" -> student.setDegree(1);
                    case "高中" -> student.setDegree(2);
                    case "大专" -> student.setDegree(3);
                    case "本科" -> student.setDegree(4);
                    case "硕士" -> student.setDegree(5);
                    case "博士" -> student.setDegree(6);
                }
                student.setClazzId(clazzId);
                student.setCreateTime(LocalDateTime.now());
                student.setUpdateTime(LocalDateTime.now());
                return student;
            }).toList();
            studentMapper.insertBatch(studentList);
        }
        log.info("学生信息导入结束");
    }

    @Override
    public List<StudentModel> list(String name, Integer degree, Integer clazzId) {
        List<Student> studentList = studentMapper.list(name, degree, clazzId);
        if(!studentList.isEmpty()){
            return studentList.stream().map(student -> {
                StudentModel sm = BeanUtil.copyProperties(student, StudentModel.class);
                sm.setGenderStr(student.getGender() == 1 ? "男" : "女");
                sm.setIsCollegeStr(student.getIsCollege() == 1 ? "是" : "否");
                switch (student.getDegree()) {
                    case 1 -> sm.setDegreeStr("初中");
                    case 2 -> sm.setDegreeStr("高中");
                    case 3 -> sm.setDegreeStr("大专");
                    case 4 -> sm.setDegreeStr("本科");
                    case 5 -> sm.setDegreeStr("硕士");
                    case 6 -> sm.setDegreeStr("博士");
                    default -> sm.setDegreeStr("未知");
                }
                return sm;
            }).toList();
        }
        return new ArrayList<>();
    }

    @Override
    public PageResult<Student> pageStudent(IPage<Student> page, StudentQueryParam param) {
        Page<Student> students =  studentMapper.pageStudent(page, param);
        return new PageResult<>(students
                .getTotal(),students.getRecords());
    }
}
