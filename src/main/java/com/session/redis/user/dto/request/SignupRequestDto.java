package com.session.redis.user.dto.request;

import com.session.redis.common.utils.SHA256;
import lombok.Getter;
import lombok.Setter;

import java.security.NoSuchAlgorithmException;

@Getter
@Setter
public class SignupRequestDto {
    private String email;
    private String password;

    public void hashPassword() throws NoSuchAlgorithmException {
        SHA256 sha256 = new SHA256();
        this.password = sha256.encrypt(this.password);
    }
}
