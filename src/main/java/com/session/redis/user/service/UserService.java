package com.session.redis.user.service;

import com.session.redis.user.dto.models.UserDto;
import com.session.redis.user.entity.UserEntity;
import com.session.redis.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity getUserById(String email) {
        return userRepository.findUserEntityByEmail(email);
    }

    @Transactional
    public UserDto signup(UserDto userDto) {
        UserEntity userEntity = userDto.toEntity();
        userEntity = userRepository.save(userEntity);
        return new UserDto(userEntity);
    }

}
