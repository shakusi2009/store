package com.stephen.store.mapper;

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
public class UserMapperTests {

    @Autowired
    private IUserMapper iUserMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("shakusi03");
        user.setPassword("12345");
        user.setCreatedUser("shakusi03");
        user.setCreatedTime(new Date());
        Integer rows =  iUserMapper.insert(user);

        System.out.println("------102-----"+rows);
    }


    @Test
    public void findByUsername() {
        User user = iUserMapper.findByUsername("shakusi02");
        System.out.println("--------103-------"+user);

    }

}
