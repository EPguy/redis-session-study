package com.session.redis.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {
    NOT_EXISTS_ID(HttpStatus.UNPROCESSABLE_ENTITY, "아이디가 일치하지 않습니다."),
    NOT_MATCHED_PASSWORD(HttpStatus.UNPROCESSABLE_ENTITY, "비밀번호가 일치하지 않습니다.");

    private HttpStatus status;
    private String message;
}
