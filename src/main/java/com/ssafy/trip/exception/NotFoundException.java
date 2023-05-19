package com.ssafy.trip.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends RuntimeException{
    private final HttpStatus statusCode = HttpStatus.NOT_FOUND;
    public NotFoundException(String message){
        super(message);
    }
}
