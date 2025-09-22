package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.annotation.LogOperation;
import com.itheima.common.LoginInfo;
import com.itheima.common.PageResult;
import com.itheima.domain.dto.EmpDto;

import com.itheima.domain.pojo.Emp;
import com.itheima.domain.pojo.EmpExpr;
import com.itheima.domain.pojo.EmpLog;
import com.itheima.domain.vo.EmpVo;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpLogMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.service.EmpLogService;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/31 下午4:14 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper mapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

    @Override
    public PageResult<EmpVo> page(EmpDto empDto) {

        // Long total = mapper.count();

        // List<EmpVo> rows = mapper.list(((page-1) * pageSize), pageSize);

        // return new PageResult<>(total,rows);

        //1. 设置PageHelper分页参数
        PageHelper.startPage(empDto.getPage(), empDto.getPageSize());

        //2. 执行查询
        List<EmpVo> empVos = mapper.list(empDto);

        //3. 封装分页结果
        Page<EmpVo> p = (Page<EmpVo>) empVos;
        return new PageResult<>(p.getTotal(), p.getResult());

    }

    @Override
    public List<Emp> list() {
        return mapper.queryAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(Emp emp) throws Exception {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            //1.保存员工基本信息
            mapper.insert(emp);

            // throw new Exception("出错了");

            //2.批量保存员工工作经历
            List<EmpExpr> exprList = emp.getExprList();
            if (exprList != null && !exprList.isEmpty()) {
                for (EmpExpr empExpr : exprList) {
                    empExpr.setEmpId(emp.getId());
                }
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            //3.开启日志
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), emp.toString());
            empLogService.insertLog(empLog);
        }
    }

    @Override
    @Transactional
    public void delete(List<Integer> ids) {

        //删除员工的基本信息
        mapper.deleteByIds(ids);

        //删除员工的工作经历
        empExprMapper.deleteByEmpIds(ids);
    }

    @Override
    public Emp getById(Integer id) {

        return mapper.getById(id);
    }

    @Override
    @Transactional
    public void update(Emp emp) {

        emp.setUpdateTime(LocalDateTime.now());

        // 1.更新员工的基本信息
        mapper.updateById(emp);

        // 2.删除员工的工作经历
        empExprMapper.deleteByEmpIds(List.of(emp.getId()));

        // 3.新增员工的工作经历
        List<EmpExpr> exprList = emp.getExprList();
        if (exprList != null && !exprList.isEmpty()) {
            for (EmpExpr empExpr : exprList) {
                empExpr.setEmpId(emp.getId());
            }
            empExprMapper.insertBatch(exprList);
        }
    }

    @Override
    public LoginInfo login(Map<String, Object> dto) {
        String username = (String) dto.get("username");

        String password = (String) dto.get("password");

        Emp emp = mapper.login(username, password);
        if (emp == null) {
            return null;
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",emp.getId());
        claims.put("username",emp.getUsername());
        String jwt = JwtUtils.generateJwt(claims);
        return new LoginInfo(emp.getId(), emp.getUsername(), emp.getName(), jwt);
    }
}
