package com.session.redis.user.dto.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.session.redis.user.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonIgnoreProperties({"password"})
public class UserDto {
    private Long idx;
    private String email;
    private String password;

    public UserDto(UserEntity userEntity) {
        this.idx = userEntity.getIdx();
        this.email = userEntity.getEmail();
        this.password = userEntity.getPassword();
    }

    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserEntity toEntity() {
        return new UserEntity(this.idx, this.email, this.password);
    }
}
