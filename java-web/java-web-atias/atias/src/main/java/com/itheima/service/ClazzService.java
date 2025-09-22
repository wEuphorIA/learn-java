package com.itheima.service;


import com.itheima.common.PageResult;
import com.itheima.domain.dto.ClazzDto;
import com.itheima.domain.pojo.Clazz;
import com.itheima.domain.vo.ClazzVo;

import java.util.List;

public interface ClazzService {



    PageResult<ClazzVo> page(ClazzDto clazzDto);

    void addClass(Clazz clazz);

    List<ClazzVo> list();

    void remove(Integer id);

    Clazz getClazzById(Integer id);

    void updateClazz(Clazz clazz);

    // PageResult<Clazz> page(ClazzDto clazzDto);
}
