package com.session.redis.common.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {
    NOT_EXISTS_ID(HttpStatus.UNPROCESSABLE_ENTITY, "존재하지 않는 아이디 입니다."),
    NOT_MATCHED_PASSWORD(HttpStatus.UNPROCESSABLE_ENTITY, "비밀번호가 일치하지 않습니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다.");

    private HttpStatus status;
    private String message;
}
