package com.stephen.store.controller;

import com.stephen.store.pojo.User;
import com.stephen.store.service.IUserService;
import com.stephen.store.service.ex.InsertException;
import com.stephen.store.service.ex.UsernameDupliatedException;
import com.stephen.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/26 21:36
 * @Desc：
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private IUserService iUserService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("reg")
    public JsonResult<Void> register(User user) {
        iUserService.Register(user);
        return new JsonResult<>(OK);
    }

}
