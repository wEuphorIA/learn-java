package com.itheima.controller.dept;

import com.itheima.common.Result;

import com.itheima.domain.pojo.Dept;
import com.itheima.service.DeptService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/30 上午10:37 */
@Slf4j
@RestController
@RequestMapping("/depts")
@Tag(name = "部门信息管理")
public class DeptController {

    @Autowired
    private DeptService service;

    @Operation(summary = "查询所有的部门列表")
    @GetMapping
    public Result list() {
        log.info("打印输出");
        List<Dept> result = service.list();
        return Result.success(result);
    }

    @Operation(summary = "根据id删除部门")
    @DeleteMapping
    public Result removeById(@RequestParam Integer id){
        service.removeById(id);
        return Result.success();
    }

    @Operation(summary = "添加部门")
    @PostMapping
    public Result addDept(@RequestBody Dept Dept){
        service.addDept(Dept);
        return Result.success();
    }

    @Operation(summary = "根据id查询部门")
    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id){
        Dept dept = service.getById(id);
        return Result.success(dept);
    }

    @Operation(summary = "修改部门")
    @PutMapping
    public Result update(@RequestBody Dept Dept){
        service.update(Dept);
        return Result.success();
    }

}
