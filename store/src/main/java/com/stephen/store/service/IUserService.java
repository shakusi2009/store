package com.stephen.store.service;

import com.stephen.store.pojo.User;

/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/26 18:52
 * @Desc：用户模块业务层接口
 */
public interface IUserService {
    /***
     * 用户注册
     * @param user
     */
    void Register(User user);

    User Login(String username, String password);

    Integer ModifyPassword(String username, String password, String modifiedUser);
}
