package com.itheima.d5_demo;

import lombok.Getter;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/6 下午6:18 */
public class SmartHomeControl {
    @Getter
    private static SmartHomeControl instance = new SmartHomeControl();

    private SmartHomeControl() {

    }

    public void printAllJD(JD[] jds){
        for (JD jd : jds) {
            System.out.println(jd);
        }
    }

    public void control(JD jd){
        System.out.println(jd.getName() + "开关已" + (jd.getStatus() ? "打开" : "关闭"));
        System.out.println("正在执行开关操作...");
        jd.press();
        System.out.println(jd.getName() + "开关已" + (jd.getStatus() ? "打开" : "关闭"));
    }
}
