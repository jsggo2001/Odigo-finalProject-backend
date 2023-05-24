package com.ssafy.trip.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice(basePackages = "com.ssafy.trip.controller") // 외에 여러 지정 방법이 있다.
public class ExcetionHandler {
    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(NOT_FOUND)
    public String illegalExHandler(IllegalStateException e) {
        log.error("[exceptionHandler] ex", e);
        return "리프레시 토큰이 만료 되었습니다.";
    }
}
