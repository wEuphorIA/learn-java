package com.itheima.d1_exception;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/9 上午10:57 */
// 1、维承Exception做爸爸。
// 2、重写构造器。

public class ItheimaAgeIllegalException extends  Exception{

    public ItheimaAgeIllegalException() {
    }

    public ItheimaAgeIllegalException(String message) {
        super(message);
    }

}
