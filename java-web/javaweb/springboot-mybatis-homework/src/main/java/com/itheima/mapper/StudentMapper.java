package com.itheima.mapper;

import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {

    //1. 开发Mapper接口方法，查询全部学生信息，并编写对应的单元测试。 【基于注解方式配置SQL】 。
    @Select("select * from student")
    List<Student> findAll();

    //2. 开发Mapper接口方法，往学生表中插入一条数据，并编写对应的单元测试。 【基于注解方式配置SQL】 。
    @Insert("insert into student (name, no, gender, phone, id_card, degree, graduation_date, create_time, update_time) values (#{name},#{no},#{gender},#{phone},#{idCard},#{degree},#{graduationDate},#{createTime},#{updateTime})")
    void insertStudent(Student student);

    //3. 开发Mapper接口方法，根据ID更新学生的学号、手机号、身份证号，并编写对应的单元测试。 【基于注解方式配置SQL】 。
    @Update("update student set id_card = #{idCard},no = #{no},phone = #{phone} where id = #{id};")
    void update(Student student);

    //4. 开发Mapper接口方法，根据ID查询学生信息，并编写对应的单元测试。 【基于XML方式配置SQL】 。
    Student getStudentById(Integer id);

    //5. 开发Mapper接口方法，根据ID删除学生信息，并编写对应的单元测试。 【基于XML方式配置SQL】 。
    void deleteById(Integer id);

}
