package com.itheima.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.common.PageResult;
import com.itheima.common.Result;
import com.itheima.domain.pojo.OperateLog;
import com.itheima.mapper.OperateLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/11 下午5:55 */
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @GetMapping("/page")
    public Result page(Integer page,Integer pageSize){
        PageHelper.startPage(page,pageSize);
        Page<OperateLog> result = operateLogMapper.page(page,pageSize);
        return Result.success(new PageResult<>(result.getTotal(),result.getResult()));
    }

}
