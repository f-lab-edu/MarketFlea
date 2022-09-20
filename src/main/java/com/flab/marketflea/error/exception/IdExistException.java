package com.flab.marketflea.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class IdExistException extends RuntimeException {

    public IdExistException(String msg) {
        super(msg);
    }
}