package com.itheima.service;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/25 下午4:52 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> list() {
        List<String> lines = userDao.list();
        List<User> list = lines.stream().map(line -> {
            String[] split = line.split(",");
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            return new User(Integer.valueOf(split[0]), split[1],
                    split[2],
                    split[3],
                    Integer.valueOf(split[4]),
                    LocalDateTime.parse(split[5], df));
        }).toList();
        return list;
    }
}
