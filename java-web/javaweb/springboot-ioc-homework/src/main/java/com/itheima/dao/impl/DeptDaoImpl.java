package com.itheima.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.itheima.dao.DeptDao;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/25 下午5:51 */
@Repository
public class DeptDaoImpl implements DeptDao {
    @Override
    public List<String> lines() {
        //1. 加载文件 ,  获取原始数据
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("dept.txt");
        List<String> lines = IoUtil.readUtf8Lines(in, new ArrayList<String>());
        return lines;
    }
}
