package com.example.springsecuritydemo.security;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@Getter
public class JwtAuthenticatedException extends AuthenticationException{

    private HttpStatus httpStatus;


    public JwtAuthenticatedException(String msg) {
        super(msg);
    }

    public JwtAuthenticatedException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }


}
