package com.itheima.service.impl;

import com.alibaba.excel.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpExprMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.*;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Override
    public PageResult<Emp> pageEmp(EmpQueryParam param) {

        Page<Emp> page = new Page<>();

        // 根据最后修改时间倒序排序
        page.addOrder(OrderItem.desc("update_time"));

        lambdaQuery().like(!StringUtils.isEmpty(param.getName()), Emp::getName, param.getName())
                .eq(param.getGender() != null, Emp::getGender, param.getGender())
                .between(param.getBegin() != null && param.getEnd() != null, Emp::getEntryDate, param.getBegin(), param.getEnd()).page(page);


        List<Emp> emps = page.getRecords();
        if (!CollectionUtils.isEmpty(emps)) {
            Set<Integer> ids = emps.stream().map(Emp::getDeptId).collect(Collectors.toSet());
            if (!CollectionUtils.isEmpty(ids)) {
                List<Dept> depts = deptMapper.selectBatchIds(ids);
                if (!CollectionUtils.isEmpty(depts)) {
                    Map<Integer, String> map = depts.stream().collect(Collectors.toMap(Dept::getId, Dept::getName));
                    emps.forEach(emp -> emp.setDeptName(map.get(emp.getDeptId())));
                }
            }
        }
        return new PageResult<>(page.getTotal(), page.getRecords());
    }

    @Override
    @Transactional
    public void saveEmp(Emp emp) {

        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        save(emp);

        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprMapper.insert(exprList);
        }

    }

    @Override
    @Transactional
    public void delete(List<Integer> ids) {

        removeByIds(ids);

        empExprMapper.delete(new LambdaQueryWrapper<EmpExpr>().in(EmpExpr::getEmpId, ids));

    }

    @Override
    public Emp getEmp(Integer id) {

        Emp emp = getById(id);

        List<EmpExpr> empExpr = empExprMapper.selectList(new LambdaQueryWrapper<EmpExpr>().eq(EmpExpr::getEmpId, id));

        emp.setExprList(empExpr);

        return emp;
    }

    @Override
    @Transactional
    public void updateEmp(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        updateById(emp);
        empExprMapper.delete(new LambdaQueryWrapper<EmpExpr>().eq(EmpExpr::getEmpId, emp.getId()));
        List<EmpExpr> exprList = emp.getExprList();
        if (!CollectionUtils.isEmpty(exprList)) {
            exprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));
            empExprMapper.insert(exprList);
        }
    }
}
