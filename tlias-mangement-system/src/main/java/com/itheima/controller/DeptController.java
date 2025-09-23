package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result findAll() {
        log.info("查询所有部门数据");
        return Result.success(deptService.list());
    }

    // 删除部门
    @DeleteMapping
    public Result deleteById(Integer id) {
        log.info("根据id删除部门，删除的部门id：{}", id);
        deptService.removeById(id);
        return Result.success();
    }

    // 新增部门
    @PostMapping
    public Result save(@RequestBody Dept dept) {
        log.info("新增部门，要新增的部门信息：{}", dept);
        deptService.save(dept);
        return Result.success();
    }

    // 根据ID查询部门信息
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询部门，要查询的id：{}", id);
        return Result.success(deptService.getById(id));
    }

    // 修改部门
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门数据，修改后的部门数据：{}", dept);
        deptService.updateById(dept);
        return Result.success();
    }
}
