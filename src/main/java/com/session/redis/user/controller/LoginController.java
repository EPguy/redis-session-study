package com.session.redis.user.controller;

import com.session.redis.exception.enums.ExceptionEnum;
import com.session.redis.exception.exception.ApiException;
import com.session.redis.user.dto.models.UserDto;
import com.session.redis.user.dto.request.LoginRequestDto;
import com.session.redis.user.dto.response.LoginResponseDto;
import com.session.redis.user.entity.UserEntity;
import com.session.redis.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class LoginController {
    UserService userService;

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto, HttpSession session) {
        UserEntity userEntity = userService.getUserById(loginRequestDto.getId());
        if(userEntity != null) {
            throw new ApiException(ExceptionEnum.NOT_EXISTS_ID);
        }

        if(!userEntity.getPassword().equals(loginRequestDto.getPassword())) {
            throw new ApiException(ExceptionEnum.NOT_MATCHED_PASSWORD);
        }

        UserDto userDto = new UserDto(userEntity);

        session.setAttribute("id", userDto.getId());

        return LoginResponseDto.builder()
                .user(userDto)
                .build();
    }

    @PostMapping("/logout")
    public HashMap<String, Object> logout(HttpSession session) {
        session.invalidate();
        return new HashMap<>(){{
            put("success", true);
        }};
    }
}
