package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.itheima.common.DeletionNotAllowedException;
import com.itheima.common.PageResult;
import com.itheima.domain.dto.ClazzDto;

import com.itheima.domain.pojo.Clazz;
import com.itheima.domain.vo.ClazzVo;
import com.itheima.mapper.ClazzMapper;
import com.itheima.mapper.StudentMapper;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/30 下午1:11 */
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;


    @Override
    public PageResult<ClazzVo> page(ClazzDto clazzDto) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(clazzDto.getPage(), clazzDto.getPageSize());

        //2. 执行查询
        List<ClazzVo> clazzList = clazzMapper.list(clazzDto);

        LocalDate now = LocalDate.now();

        for (ClazzVo clazzVo : clazzList) {
            if (clazzVo.getEndDate() != null && now.isAfter(clazzVo.getEndDate())) {
                clazzVo.setStatus("已结课");
            } else if (clazzVo.getBeginDate() != null && now.isBefore(clazzVo.getBeginDate())) {
                clazzVo.setStatus("未开班");
            } else {
                clazzVo.setStatus("在读中");
            }
        }
        //3. 封装分页结果
        Page<ClazzVo> p = (Page<ClazzVo>) clazzList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void addClass(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public List<ClazzVo> list() {

        return clazzMapper.queryALl();
    }

    @Override
    public void remove(Integer id) {
        //如果这个班级下面有学生那就不能删
        Integer count = studentMapper.isStudent(id);
        if (count != null && count > 0){
            throw new DeletionNotAllowedException("对不起, 该班级下有学生, 不能直接删除");
        }
        clazzMapper.remove(id);
    }

    @Override
    public Clazz getClazzById(Integer id) {
        return clazzMapper.selectById(id);
    }

    @Override
    public void updateClazz(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateClazz(clazz);
    }


}
