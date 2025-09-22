package com.itheima.controller;

import com.itheima.common.CountOption;
import com.itheima.common.JobOption;
import com.itheima.common.Result;
import com.itheima.service.ReportService;
import com.itheima.service.impl.ReportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/3 下午7:26 */
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService service;

    @GetMapping("/empJobData")
    public Result empJobData() {
        JobOption result = service.empJobData();
        return Result.success(result);
    }

    @GetMapping("/empGenderData")
    public Result empGenderData() {
        List<Map<String, Object>> result = service.empGenderData();
        return Result.success(result);
    }

    @GetMapping("/studentDegreeData")
    public Result studentDegreeData() {
        List<Map<String, Object>> result = service.studentDegreeData();
        return Result.success(result);
    }

    @GetMapping("/studentCountData")
    public Result studentCountData() {
        CountOption result = service.studentCountData();
        return Result.success(result);
    }
}
