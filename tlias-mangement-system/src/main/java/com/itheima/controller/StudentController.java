package com.itheima.controller;


import com.alibaba.excel.EasyExcel;

import com.alibaba.excel.util.StringUtils;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.excel.StudentListener;
import com.itheima.excel.model.StudentModel;
import com.itheima.pojo.*;
import com.itheima.service.StudentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @GetMapping
    public Result list(StudentQueryParam param) {
        log.info("查询所有学生信息：{}", param);
        IPage<Student> page = new Page<>(param.getPage(), param.getPageSize());
        PageResult<Student> result = studentService.pageStudent(page,param);
        return Result.success(result);
    }

    @PostMapping
    public Result save(@RequestBody Student student) {
        log.info("新增学生信息：{}", student);
        student.setUpdateTime(LocalDateTime.now());
        student.setCreateTime(LocalDateTime.now());
        studentService.saveOrUpdate(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据id查询学生信息：{}", id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Student student) {
        log.info("修改学生信息：{}", student);
        student.setUpdateTime(LocalDateTime.now());
        studentService.saveOrUpdate(student);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("根据id删除学生信息：{}", ids);
        studentService.removeByIds(ids);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score) {
        log.info("根据id{}扣分, 扣分：{}", id, score);
        LambdaUpdateWrapper<Student> queryWrapper = new LambdaUpdateWrapper<>();
        queryWrapper.setSql("violation_score = violation_score + ?", score);
        queryWrapper.setSql("violation_count = violation_count + 1");
        queryWrapper.eq(Student::getId, id);
        studentService.update(queryWrapper);
        return Result.success();
    }

    /**
     * 导入学生信息
     */
    @PostMapping("/import/{clazzId}")
    public Result importStudent(MultipartFile file, @PathVariable Integer clazzId) throws IOException {
        log.info("批量导入学生信息");
        EasyExcel.read(file.getInputStream(),
                        StudentModel.class,
                        new StudentListener(studentService, clazzId))
                .sheet().doRead();
        return Result.success();
    }

    /**
     * 导出学生信息
     */
    @GetMapping("/export")
    public void exportStudent(HttpServletResponse response, String name, Integer degree, Integer clazzId) throws IOException {
        log.info("导出学生信息, {}, {}, {}", name, degree, clazzId);
        List<StudentModel> studentModelList = studentService.list(name, degree, clazzId);
        //response.setHeader("Content-Disposition", "attachment;filename=student.xlsx");
        WriteCellStyle writeCellStyle = new WriteCellStyle();
        writeCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);

        EasyExcel.write(response.getOutputStream(), StudentModel.class)
                .sheet("学员信息列表")
                .registerWriteHandler(new HorizontalCellStyleStrategy(null, writeCellStyle))
                .doWrite(studentModelList);
    }
}
