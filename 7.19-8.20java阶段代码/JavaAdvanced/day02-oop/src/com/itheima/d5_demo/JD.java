package com.itheima.d5_demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 下午6:15 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class JD implements Switch {

    private String name;

    private Boolean status;

    @Override
    public void press() {
        status = !status;
    }
}
