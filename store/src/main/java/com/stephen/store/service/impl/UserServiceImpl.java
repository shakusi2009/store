package com.stephen.store.service.impl;

import com.stephen.store.mapper.IUserMapper;
import com.stephen.store.pojo.User;
import com.stephen.store.service.IUserService;
import com.stephen.store.service.ex.InsertException;
import com.stephen.store.service.ex.PasswordNotMatchException;
import com.stephen.store.service.ex.UserNotExistException;
import com.stephen.store.service.ex.UsernameDupliatedException;
import com.stephen.store.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/26 18:53
 * @Desc：
 */

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper iUserMapper;

    @Autowired
    private CommonUtil commonUtil;

    @Override
    public void Register(User user) {

        String username = user.getUsername();

        User result = iUserMapper.findByUsername(username);
        if (result != null) {
            throw new UsernameDupliatedException("用户名被占用!");
        }

        user.setIsDelete(0);
        Date date = new Date();
        user.setCreatedUser(username);
        user.setModifiedUser(username);
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        String oldPassword = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = commonUtil.getMD5Encrypt(oldPassword, salt);
        user.setPassword(md5Password);
        user.setSalt(salt);

        Integer rows = iUserMapper.insert(user);
        if (rows != 1) {
            throw new InsertException("用户注册过程中产生未知的异常!");
        }


    }

    @Override
    public User Login(String username, String password) {
        User result = iUserMapper.findByUsername(username);
        if (result == null) {
            throw new UserNotExistException("用户不存在");
        }

        //登陆密码加盐
        String md5Password = commonUtil.getMD5Encrypt(password, result.getSalt());
        if (!md5Password.equals(result.getPassword())) {
            throw new PasswordNotMatchException("账号密码不正确！");
        }

        return result;
    }
}
