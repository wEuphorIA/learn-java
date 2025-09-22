package com.itheima.mapper;

import com.itheima.annotation.LogOperation;
import com.itheima.domain.pojo.Dept;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@Mapper
public interface DeptMapper {

    @Select("select id, name, create_time, update_time from dept order by update_time desc")
    List<Dept> selectAll();

    @Delete("delete from dept where id = #{id}")
    @LogOperation
    void removeById(Integer id);

    @Insert("insert into dept (name,create_time,update_time) values (#{name},#{createTime},#{updateTime});")
    @LogOperation
    void insertDept(Dept dept);

    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept selectById(Integer id);

    @Update("update dept set name = #{name},update_time = #{updateTime} where  id = #{id};")
    @LogOperation
    void update(Dept dept);

    @Select("select count(*) from emp where dept_id = #{id}")
    Integer count(Integer id);
}
