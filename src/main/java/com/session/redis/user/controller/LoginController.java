package com.session.redis.user.controller;

import com.session.redis.common.exception.enums.ExceptionEnum;
import com.session.redis.common.exception.exception.ApiException;
import com.session.redis.user.dto.models.UserDto;
import com.session.redis.user.dto.request.SigninRequestDto;
import com.session.redis.user.dto.request.SignupRequestDto;
import com.session.redis.user.dto.response.SigninResponseDto;
import com.session.redis.user.entity.UserEntity;
import com.session.redis.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;

    @PostMapping("/signin")
    public SigninResponseDto signin(@RequestBody SigninRequestDto signinRequestDto, HttpSession session) throws NoSuchAlgorithmException {
        UserEntity userEntity = userService.getUserById(signinRequestDto.getEmail());

        if(userEntity == null) {
            throw new ApiException(ExceptionEnum.NOT_EXISTS_EMAIL);
        }

        signinRequestDto.hashPassword();

        if(!userEntity.getPassword().equals(signinRequestDto.getPassword())) {
            throw new ApiException(ExceptionEnum.NOT_MATCHED_PASSWORD);
        }

        UserDto userDto = new UserDto(userEntity);

        session.setAttribute("email", userDto.getEmail());

        return SigninResponseDto.builder()
                .user(userDto)
                .build();
    }

    @PostMapping("/signup")
    public SigninResponseDto signup(@RequestBody SignupRequestDto signupRequestDto) throws NoSuchAlgorithmException {
        UserEntity userEntity = userService.getUserById(signupRequestDto.getEmail());

        if(userEntity != null) {
            throw new ApiException(ExceptionEnum.EXISTS_EMAIL);
        }

        signupRequestDto.hashPassword();

        UserDto userDto = new UserDto(signupRequestDto.getEmail(), signupRequestDto.getPassword());

        userDto = userService.signup(userDto);

        return SigninResponseDto.builder()
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
