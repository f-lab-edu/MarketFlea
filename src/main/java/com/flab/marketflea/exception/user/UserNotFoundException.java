package com.flab.marketflea.exception.user;

import com.flab.marketflea.common.ErrorCode;
import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private ErrorCode errorCode;

    public UserNotFoundException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
