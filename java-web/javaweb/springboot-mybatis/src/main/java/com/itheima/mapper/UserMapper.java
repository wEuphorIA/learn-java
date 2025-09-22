package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {

    //@Select("select * from user where username = #{username} and password = #{password}")
    //public List<User> getByUsernameAndPassword(String username , String password);

    // @Select("select id, username, password, name, age from user")

    List<User> findAll();

    @Update("update user set username = #{username},password = #{password} , name = #{name},age = #{age}  where id = #{id};")
    void updateById(User user);

    @Insert("insert into user (username, password, name, age) values (#{username},#{password},#{name},#{age});")
    void insertUser(User user);

    @Select("select id, username, password, name, age from user where username = #{username} and password = #{password}")
    List<User> getByUserNameAndPwd(String username,String password);

}
