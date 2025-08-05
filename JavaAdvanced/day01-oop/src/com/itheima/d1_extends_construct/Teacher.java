package com.itheima.d1_extends_construct;



/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/3 下午2:59 */
public class Teacher extends com.itheima.d1_extends_construct.People {
    private String skill;

    public Teacher(String name, int age, String skill) {
        super(name, age);
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}
