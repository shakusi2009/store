package com.stephen.store.service.ex;

/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/26 18:51
 * @Desc：
 */
public class UsernameDupliatedException extends ServiceException {
    public UsernameDupliatedException() {
        super();
    }

    public UsernameDupliatedException(String message) {
        super(message);
    }

    public UsernameDupliatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameDupliatedException(Throwable cause) {
        super(cause);
    }

    public UsernameDupliatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
