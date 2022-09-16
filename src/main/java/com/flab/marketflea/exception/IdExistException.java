package com.flab.marketflea.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class IdExistException extends RuntimeException{

    public IdExistException() {
        super("이미 존재하는 아이디입니다.");
    }
}
