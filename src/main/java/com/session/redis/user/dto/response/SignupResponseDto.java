package com.session.redis.user.dto.response;

import com.session.redis.user.dto.models.UserDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignupResponseDto {
    private UserDto user;
}
