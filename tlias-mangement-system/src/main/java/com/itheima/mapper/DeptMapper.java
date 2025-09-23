package com.itheima.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

// @Mapper
public interface DeptMapper extends BaseMapper<Dept> {

    // @Select("select id, name, create_time, update_time from dept order by update_time desc ")
    // List<Dept> findAll();
    //
    // @Delete("delete from dept where id = #{id}")
    // void deleteById(Integer id);
    //
    // @Insert("insert into dept(name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    // void save(Dept dept);
    //
    // @Select("select id, name, create_time, update_time from dept where id = #{id}")
    // Dept getById(Integer id);
    //
    // void update(Dept dept);
}
