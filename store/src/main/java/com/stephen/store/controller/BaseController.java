package com.stephen.store.controller;

import com.stephen.store.service.ex.*;
import com.stephen.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/26 21:56
 * @Desc：Controller基类
 */
public class BaseController {
    public static final int OK = 200;

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>();
        if (e instanceof UsernameDupliatedException) {
            result.setState(4000);
        } else if (e instanceof InsertException) {
            result.setState(5000);
        } else if (e instanceof UserNotExistException) {
            result.setState(4001);
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(5001);
        }
        result.setMessage(e.getMessage());

        return result;

    }

    protected final Integer getUidFromSession(HttpSession httpSession) {
        return Integer.valueOf(httpSession.getAttribute("uid").toString());

    }

    protected final String getUsernameFromSession(HttpSession httpSession) {
        return httpSession.getAttribute("username").toString();
    }
}
