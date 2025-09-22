package com.itheima.service;

import com.itheima.common.LoginInfo;
import com.itheima.common.PageResult;
import com.itheima.domain.dto.EmpDto;
import com.itheima.domain.pojo.Emp;
import com.itheima.domain.vo.EmpVo;

import java.util.List;
import java.util.Map;

public interface EmpService {
    PageResult<EmpVo> page(EmpDto empDto);

    List<Emp> list();

    void add(Emp emp) throws Exception;

    void delete(List<Integer> ids);

    Emp getById(Integer id);

    void update(Emp emp);

    LoginInfo login(Map<String, Object> dto);
}
