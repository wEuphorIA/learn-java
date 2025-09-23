package com.itheima.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.itheima.excel.model.StudentModel;
import com.itheima.service.StudentService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class StudentListener implements ReadListener<StudentModel> {

    private List<StudentModel> cachedDataList = new ArrayList<>();

    private Integer clazzId;
    private StudentService studentService;
    public StudentListener(StudentService studentService, Integer clazzId) {
        this.studentService = studentService;
        this.clazzId = clazzId;
    }

    /**
     * 这个每一条数据解析都会来调用
     */
    @Override
    public void invoke(StudentModel sm, AnalysisContext context) {
        log.info("解析到一条数据:{}", sm);
        cachedDataList.add(sm);
    }

    /**
     * 所有数据解析完成了都会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有数据解析完成！");
        studentService.importStudent(cachedDataList, clazzId);
    }

}