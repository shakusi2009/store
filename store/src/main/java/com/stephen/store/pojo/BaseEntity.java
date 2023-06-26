package com.stephen.store.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/26 17:57
 * @Desc：实体类基类
 */
@Data
public class BaseEntity implements Serializable {
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;
}
