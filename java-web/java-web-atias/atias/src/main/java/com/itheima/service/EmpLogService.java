package com.itheima.service;

import com.itheima.domain.pojo.EmpLog;

public interface EmpLogService {
        //记录新增员工日志
     void insertLog(EmpLog empLog);
}