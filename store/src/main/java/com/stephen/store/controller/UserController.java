package com.stephen.store.controller;

import com.stephen.store.pojo.User;
import com.stephen.store.service.IUserService;
import com.stephen.store.service.ex.InsertException;
import com.stephen.store.service.ex.UsernameDupliatedException;
import com.stephen.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

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

    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession httpSession) {
        User user = iUserService.Login(username, password);
        //写session
        httpSession.setAttribute("uid", user.getUid());
        httpSession.setAttribute("username", user.getUsername());

        //print
        System.out.println("-------108--------"+getUidFromSession(httpSession));
        System.out.println("-------109--------"+getUsernameFromSession(httpSession));
        return new JsonResult<User>(OK, user);
    }

}
