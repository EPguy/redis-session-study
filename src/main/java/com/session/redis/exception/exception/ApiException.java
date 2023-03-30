package com.session.redis.exception.exception;

import com.session.redis.exception.enums.ExceptionEnum;

public class ApiException extends RuntimeException{
    private ExceptionEnum error;

    public ApiException(ExceptionEnum e) {
        super(e.getMessage());
        this.error = e;
    }
}
