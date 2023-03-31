package com.session.redis.common.exception.exception;

import com.session.redis.common.exception.enums.ExceptionEnum;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{
    private ExceptionEnum error;

    public ApiException(ExceptionEnum e) {
        super(e.getMessage());
        this.error = e;
    }
}
