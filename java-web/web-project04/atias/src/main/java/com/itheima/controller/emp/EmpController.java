package com.itheima.controller.emp;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/31 下午4:15 */

import com.itheima.annotation.LogOperation;
import com.itheima.common.PageResult;
import com.itheima.common.Result;
import com.itheima.domain.dto.EmpDto;

import com.itheima.domain.pojo.Emp;
import com.itheima.domain.vo.EmpVo;
import com.itheima.service.EmpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emps")
@Tag(name = "员工信息管理")
public class EmpController {

    @Autowired
    private EmpService service;

    @Operation(summary = "查询所有的员工列表条件分页查询")
    @GetMapping
    public Result page(EmpDto empDto) {
        PageResult<EmpVo> result = service.page(empDto);
        return Result.success(result);
    }

    @Operation(summary = "查询所有的员工列表")
    @GetMapping("/list")
    public Result list() {
        List<Emp> result = service.list();
        return Result.success(result);
    }

    @Operation(summary = "新增员工")
    @PostMapping()
    public Result add(@RequestBody Emp emp) throws Exception {
        service.add(emp);
        return Result.success();
    }

    @Operation(summary = "删除员工")
    @DeleteMapping

    public Result delete(@RequestParam List<Integer> ids){
        service.delete(ids);
        return Result.success();
    }

    @Operation(summary = "根据id查询员工的详细信息")
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Emp emp = service.getById(id);
        return Result.success(emp);
    }

    @Operation(summary = "更新员工信息")
    @PutMapping
    public Result update(@RequestBody Emp emp){
        service.update(emp);
        return Result.success();
    }
}


