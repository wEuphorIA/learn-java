package com.itheima.contorller;

import cn.hutool.core.io.IoUtil;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 @author Euphoria
 @version 1.0
 @description: TODO
 @date 2025/8/25 下午2:23 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private ArrayList<User> userList = new ArrayList<>();

    @RequestMapping("/list")
    public ArrayList<User> list() {


        try (BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\wyk\\Desktop\\code\\java-web\\javaweb\\day02-springboot2\\src\\main\\resources\\user.txt"))) {
            String line;
            while ((line = bf.readLine()) != null) {

                String[] split = line.split(",");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                userList.add(new User(
                        Integer.valueOf(split[0]),
                        split[1],
                        split[2],
                        split[3],
                        Integer.valueOf(split[4]),
                        LocalDateTime.parse(split[5], formatter)
                ));
            }
            System.out.println(userList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @RequestMapping("/list1")
    public List<User> list1() {

        return userService.list();
    }
}

