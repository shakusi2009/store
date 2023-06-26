package com.stephen.store.util;

import java.io.Serializable;

/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/26 21:29
 * @Desc：Json数据封装类
 */
public class JsonResult<T> implements Serializable {
    /**
     * 状态码
     */
    private Integer state;

    /**
     * 描述信息
     */
    private String message;

    /**
     * 数据（范型）
     */
    private T data;

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Integer state, T data) {
        this.state = state;
        this.data = data;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public Integer getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
