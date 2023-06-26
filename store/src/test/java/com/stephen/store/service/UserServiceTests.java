package com.stephen.store.service;

import com.stephen.store.mapper.IUserMapper;
import com.stephen.store.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/26 18:30
 * @Desc：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {

    @Autowired
    private IUserService iUserService;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("shakusi04");
            user.setPassword("12345");

            iUserService.Register(user);
            System.out.println("------104-----> ok");
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Test
    public void login() {
        User user = iUserService.Login("shakusi04", "12345");
        System.out.println("------105-----> ok");
        System.out.println(user);
    }


}
