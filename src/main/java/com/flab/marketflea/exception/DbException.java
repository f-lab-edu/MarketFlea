package com.flab.marketflea.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DbException extends RuntimeException {

    public DbException() {
        super("데이터베이스 참조과정에서 문제가 발생했습니다.");
    }
}
