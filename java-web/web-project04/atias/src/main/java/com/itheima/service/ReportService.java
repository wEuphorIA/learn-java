package com.itheima.service;

import com.itheima.common.CountOption;
import com.itheima.common.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption empJobData();

    List<Map<String, Object>> empGenderData();

    List<Map<String, Object>> studentDegreeData();

    CountOption studentCountData();
}
