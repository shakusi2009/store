package com.stephen.store.mapper;

import com.stephen.store.pojo.User;

/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/26 18:07
 * @Desc：用户模块持久层接口
 */
public interface IUserMapper {
    /**
     * 新增用户
     * @param user
     * @return
     */
    Integer insert(User user);

    /**
     * 查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 修改密码
     * @param username
     * @param password
     * @param modifiedUser
     * @return
     */
    Integer modifyPassword(String username, String password, String modifiedUser);

}
