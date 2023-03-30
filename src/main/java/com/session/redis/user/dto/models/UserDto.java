package com.session.redis.user.dto.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.session.redis.user.entity.UserEntity;
import lombok.Getter;

@Getter
public class UserDto {
    private Long idx;
    private String id;
    private String password;

    public UserDto(UserEntity userEntity) {
        this.idx = userEntity.getIdx();
        this.id = userEntity.getId();
        this.password = userEntity.getPassword();
    }
}
