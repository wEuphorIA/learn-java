package com.itheima.mapper;

import com.github.pagehelper.Page;
import com.itheima.annotation.LogOperation;
import com.itheima.domain.dto.EmpDto;
import com.itheima.domain.pojo.Emp;
import com.itheima.domain.vo.EmpVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;

@Mapper

public interface EmpMapper {


    List<EmpVo> list(EmpDto empDto);


    @Select("select id, username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time from emp")
    List<Emp> queryAll();

    @Insert("insert into emp (username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    void updateById(Emp emp);

    List<Map<String, Object>> empJobData();

    List<Map<String, Object>> empGenderData();

    @Select("select * from emp where username=#{username} and password=#{password}")
    Emp login(String username, String password);


    // @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    // Long count();


    // @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc limit #{i},#{pageSize}")
    // List<EmpVo> list(int i, Integer pageSize);
}
