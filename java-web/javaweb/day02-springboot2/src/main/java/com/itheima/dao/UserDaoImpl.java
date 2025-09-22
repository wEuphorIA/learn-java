package com.itheima.dao;

import cn.hutool.core.io.IoUtil;
import com.itheima.contorller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/25 下午4:53 */
@Repository
public class UserDaoImpl implements UserDao{

    @Override
    public List<String> list() {
        InputStream is = UserController.class.getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = new ArrayList<>();
        IoUtil.readLines(is, StandardCharsets.UTF_8, lines);
        return lines;
    }
}
