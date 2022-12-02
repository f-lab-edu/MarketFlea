package com.flab.marketflea.exception.user;

import com.flab.marketflea.common.ErrorCode;
import lombok.Getter;

@Getter
public class WrongPasswordException extends IllegalArgumentException {
    private ErrorCode errorCode;

    public WrongPasswordException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
