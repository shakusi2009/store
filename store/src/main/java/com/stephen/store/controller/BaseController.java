package com.stephen.store.controller;

import com.stephen.store.service.ex.InsertException;
import com.stephen.store.service.ex.ServiceException;
import com.stephen.store.service.ex.UsernameDupliatedException;
import com.stephen.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
            result.setMessage(e.getMessage());
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage(e.getMessage());
        }

        return result;

    }
}
