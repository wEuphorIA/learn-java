package com.itheima;

import java.util.List;

public interface UserMapper {

    //@Select("select * from user where username = #{username} and password = #{password}")
    public List<User> getByUsernameAndPassword(String username , String password);
}
