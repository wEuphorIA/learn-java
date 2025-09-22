package com.itheima.domain.vo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/9/2 上午10:45 */
@Data
public class ClazzVo {

    private Integer id; //ID

    private String name; //班级名称

    private String room; //班级教室

    private LocalDate beginDate; //开课时间

    private LocalDate endDate; //结课时间

    private Integer masterId; //班主任

    // private Integer subject; //学科

    private LocalDateTime createTime; //创建时间

    private LocalDateTime updateTime; //修改时间

    private String masterName; //班主任姓名

    private String status; //班级状态 - 未开班 , 在读 , 已结课

}
