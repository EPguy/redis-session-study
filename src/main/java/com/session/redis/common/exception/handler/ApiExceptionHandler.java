package com.session.redis.common.exception.handler;

import com.session.redis.common.exception.dto.ExceptionResponse;
import com.session.redis.common.exception.exception.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(ApiException.class)
    protected ResponseEntity handleApiException(ApiException e) {
        logger.error("handleApiException", e);

        ExceptionResponse response = new ExceptionResponse(e.getError().getStatus().toString(), e.getMessage());

        return new ResponseEntity(response, e.getError().getStatus());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity handleException(Exception e) {
        logger.error("handleException", e);

        ExceptionResponse response = new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), e.toString());

        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
