package com.session.redis.user.dto.response;

import com.session.redis.user.dto.models.UserDto;
import com.session.redis.user.entity.UserEntity;
import lombok.Builder;

@Builder
public class LoginResponseDto {
    private UserDto user;
}
