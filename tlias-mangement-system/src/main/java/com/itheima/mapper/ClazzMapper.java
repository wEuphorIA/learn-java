package com.itheima.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.pojo.Clazz;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;

@Mapper
public interface ClazzMapper extends BaseMapper<Clazz> {

    IPage<Clazz> pageClazz(Page<Clazz> clazzPage,String name, LocalDate begin, LocalDate end);
}
