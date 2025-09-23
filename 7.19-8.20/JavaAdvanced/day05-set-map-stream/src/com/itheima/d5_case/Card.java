package com.itheima.d5_case;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/13 上午10:48 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Card {

    private String size;

    private String color;

    private Integer sorted;//排序的序号

    @Override
    public String toString() {
        return size+(color == null ? "" : color);
    }
}
