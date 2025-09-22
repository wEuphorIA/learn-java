package com.itheima.mapper;


import com.itheima.domain.dto.ClazzDto;
import com.itheima.domain.pojo.Clazz;
import com.itheima.domain.vo.ClazzVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClazzMapper {
    


    List<ClazzVo> list(ClazzDto clazzDto);

    @Insert("insert into clazz (name, room, begin_date, end_date, master_id, subject, create_time, update_time) values (#{name},#{room},#{beginDate},#{endDate},#{masterId},#{subject},#{createTime},#{updateTime})")
    void insert(Clazz clazz);

    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from clazz")
    List<ClazzVo> queryALl();

    @Delete("delete from clazz where id = #{id}")
    void remove(Integer id);

    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from clazz where id = #{id}")
    Clazz selectById(Integer id);

    // @Update("update clazz set name = #{name}, room = #{room}, begin_date = #{beginDate}, end_date = #{endDate}, master_id = #{masterId}, subject = #{subject} where id = #{id}")
    void updateClazz(Clazz clazz);


}
