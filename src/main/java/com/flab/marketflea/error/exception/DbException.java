package com.flab.marketflea.error.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DbException extends Throwable {

    public DbException(String msg) {
        super(msg);

    }
}
