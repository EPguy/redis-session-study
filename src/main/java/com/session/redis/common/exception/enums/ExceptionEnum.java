package com.session.redis.common.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {
    NOT_EXISTS_EMAIL(HttpStatus.FORBIDDEN, "존재하지 않는 이메일 입니다."),
    NOT_MATCHED_PASSWORD(HttpStatus.FORBIDDEN, "비밀번호가 일치하지 않습니다."),
    EXISTS_EMAIL(HttpStatus.CONFLICT, "이미 존재하는 이메일 입니다."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다.");

    private HttpStatus status;
    private String message;
}
