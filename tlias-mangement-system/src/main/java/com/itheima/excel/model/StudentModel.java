package com.itheima.excel.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;
import java.time.LocalDate;

@Data
@HeadRowHeight(30)
@ContentRowHeight(20)
public class StudentModel {
    @ColumnWidth(14)
    @ExcelProperty("姓名")
    private String name;

    @ColumnWidth(16)
    @ExcelProperty("学号")
    private String no;

    @ColumnWidth(10)
    @ExcelProperty("性别")
    private String genderStr;

    @ColumnWidth(16)
    @ExcelProperty("手机号")
    private String phone;

    @ColumnWidth(22)
    @ExcelProperty("身份证号")
    private String idCard;

    @ColumnWidth(17)
    @ExcelProperty("是否来自院校")
    private String isCollegeStr;

    @ColumnWidth(31)
    @ExcelProperty("居住地址")
    private String address;

    @ColumnWidth(11)
    @ExcelProperty("学历")
    private String degreeStr;

    @ColumnWidth(17)
    @ExcelProperty("毕业时间")
    private LocalDate graduationDate;

    @ColumnWidth(25)
    @ExcelProperty("班级")
    private String clazzName;
}