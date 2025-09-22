package com.itheima.controller;

import com.itheima.common.PageResult;
import com.itheima.common.Result;
import com.itheima.domain.dto.StudentDto;
import com.itheima.domain.pojo.Student;
import com.itheima.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/3 下午7:33 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @Operation(summary = "查询所有的学员列表条件分页查询")
    @GetMapping
    public Result getAll(StudentDto studentDto){
        PageResult<Student> result = service.getAll(studentDto);
        return Result.success(result);
    }

    @DeleteMapping("{ids}")
    @Operation(summary = "批量删除")
    public Result delete(@PathVariable List<Integer> ids){
        service.delete(ids);
        return Result.success();
    }


    @PostMapping
    @Operation(summary = "添加学员信息")
    public Result add(@RequestBody Student student){
        service.add(student);
        return Result.success();
    }

    @GetMapping("{id}")
    @Operation(summary = "根据ID查询")
    public Result getById(@PathVariable Integer id){
        Student student = service.getById(id);
        return Result.success(student);
    }

    @PutMapping
    @Operation(summary = "修改学员")
    public Result update(@RequestBody Student student){
        service.update(student);
        return Result.success();
    }


    @PutMapping("/violation/{id}/{score}")
    @Operation(summary = "违纪处理")
    public Result update(@PathVariable Integer id,@PathVariable Short score){
        service.updateCount(id,score);
        return Result.success();
    }

}
