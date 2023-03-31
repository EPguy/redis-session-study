package com.session.redis.common.interceptor;

import com.session.redis.common.exception.enums.ExceptionEnum;
import com.session.redis.common.exception.exception.ApiException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HttpSession session = request.getSession();
        if(session.getAttribute("id") == null) {
            throw new ApiException(ExceptionEnum.UNAUTHORIZED);
        }
        return true;
    }
}
