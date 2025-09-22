package com.itheima.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.itheima.dao.LogDao;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.ArrayList;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/25 下午6:00 */
@Repository
public class LogDaoImpl implements LogDao {
    @Override
    public ArrayList<String> lines() {
        //1. 加载log.txt文件数据
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("log.txt");
        ArrayList<String> lines = IoUtil.readUtf8Lines(inputStream, new ArrayList<String>());
        return lines;
    }
}
