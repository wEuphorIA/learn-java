package com.itheima.mapper;

import com.itheima.common.CountOption;
import com.itheima.domain.dto.StudentDto;
import com.itheima.domain.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    List<Student> selectAll(StudentDto studentDto);


    void delete(List<Integer> ids);

    void addStudent(Student student);

    @Select("select id, name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, violation_count, violation_score, create_time, update_time from student where id = #{id}")
    Student getById(Integer id);


    void update(Student student);

    List<Map<String, Object>> studentDegreeData();

    List<Map<String, Object>> studentCountData();

    @Select("select count(*) from student where clazz_id = #{id}")
    Integer isStudent(Integer id);
}
