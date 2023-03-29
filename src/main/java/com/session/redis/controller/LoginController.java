package com.session.redis.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@RestController
public class LoginController {
    @PostMapping("/login")
    public HashMap<String, Object> login(HttpSession session) {
        UUID uid = Optional.ofNullable(UUID.class.cast(session.getAttribute("uid")))
                .orElse(UUID.randomUUID());
        session.setAttribute("uid", uid);
        return new HashMap<>(){{
            put("success", true);
        }};
    }

    @GetMapping("/info")
    public HashMap<String, Object> info(HttpSession session) {
        String id = ((UUID) session.getAttribute("uid")).toString();
        return new HashMap<>(){{
            put("id", id);
        }};
    }

    @PostMapping("/logout")
    public HashMap<String, Object> logout(HttpSession session) {
        session.invalidate();
        return new HashMap<>(){{
            put("success", true);
        }};
    }
}
