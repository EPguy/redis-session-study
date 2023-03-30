package com.session.redis.user.service;

import com.session.redis.user.entity.UserEntity;
import com.session.redis.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity getUserById(String username) {
        return userRepository.findUserEntityById(username);
    }
}
