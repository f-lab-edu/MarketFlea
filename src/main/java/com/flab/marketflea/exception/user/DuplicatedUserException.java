package com.flab.marketflea.exception.user;

import com.flab.marketflea.common.ErrorCode;
import lombok.Getter;

@Getter
public class DuplicatedUserException extends RuntimeException {
    private ErrorCode errorCode;

    public DuplicatedUserException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}