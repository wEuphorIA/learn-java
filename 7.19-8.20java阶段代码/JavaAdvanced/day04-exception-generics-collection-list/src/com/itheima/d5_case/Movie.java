package com.itheima.d5_case;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/10 下午4:16 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private String name;//电影名称
    private double score;//评分
    private String actor;//演员
    private double price;//价格
}
