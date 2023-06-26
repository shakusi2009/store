package com.stephen.store.util;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/26 21:15
 * @Desc：
 */
@Component
public class CommonUtil {
    public String getMD5Encrypt(String pwd, String salt) {
        for (int i = 0; i < 3; i++) {
            pwd = DigestUtils.md5DigestAsHex((salt+pwd+salt).getBytes()).toUpperCase();
        }
        return pwd;
    }
}
