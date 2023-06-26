package com.stephen.store.pojo;

import lombok.Data;

/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/26 18:05
 * @Desc：用户类
 */

@Data
public class User extends BaseEntity{
    private Integer uid;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private Integer isDelete;
}
