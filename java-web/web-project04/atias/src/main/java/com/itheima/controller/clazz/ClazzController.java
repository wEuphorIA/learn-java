package com.itheima.controller.clazz;

import com.itheima.common.PageResult;
import com.itheima.common.Result;


import com.itheima.domain.dto.ClazzDto;
import com.itheima.domain.pojo.Clazz;
import com.itheima.domain.vo.ClazzVo;
import com.itheima.service.ClazzService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/30 下午1:12 */
@RestController
@RequestMapping("/clazzs")
@Tag(name = "班级信息管理")
public class ClazzController {

    @Autowired
    private ClazzService service;

    @Operation(summary = "查询所有的班级列表,条件分页查询")
    @GetMapping()
    public Result listQuery(ClazzDto clazzDto) {
        PageResult<ClazzVo> result = service.page(clazzDto);
        return Result.success(result);
    }

    @Operation(summary = "新增班级信息")
    @PostMapping
    public Result addClass(@RequestBody Clazz clazz) {
        service.addClass(clazz);
        return Result.success();
    }

    @Operation(summary = "查询所有的班级列表")
    @GetMapping("/list")
    public Result list() {
        List<ClazzVo> result = service.list();
        return Result.success(result);
    }

    @Operation(summary = "删除班级")
    @DeleteMapping("/{id}")
    public Result remove(@PathVariable Integer id) {
        service.remove(id);
        return Result.success();
    }


    @Operation(summary = "根据id查询当前班级")
    @GetMapping("/{id}")
    public Result getClazzById(@PathVariable Integer id) {
        Clazz result = service.getClazzById(id);
        return Result.success(result);
    }

    @Operation(summary = "修改班级")
    @PutMapping()
    public Result updateClazz(@RequestBody Clazz clazz) {
        service.updateClazz(clazz);
        return Result.success();
    }

}
