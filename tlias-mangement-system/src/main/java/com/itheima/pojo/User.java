package com.itheima.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_user")
public class User {

    private Long id;

    @TableField("username")
    private String name;

    @TableField("is_married")
    private Boolean isMarried;

    @TableField("`order`")
    private Integer order;

    @TableField(exist = false)
    private String address;
}