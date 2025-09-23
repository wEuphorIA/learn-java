package com.itheima.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {

    @TableId(value = "id", type = IdType.AUTO) //设置主键自增，默认使用的id生成方式是雪花算法
    private Integer id;

    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}