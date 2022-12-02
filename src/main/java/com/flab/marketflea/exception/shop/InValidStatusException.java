package com.flab.marketflea.exception.shop;

import com.flab.marketflea.common.ErrorCode;
import lombok.Getter;

@Getter
public class InValidStatusException extends IllegalArgumentException {
    private ErrorCode errorCode;

    public InValidStatusException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}