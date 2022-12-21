package com.flab.marketflea.exception.product;

import com.flab.marketflea.common.ErrorCode;
import lombok.Getter;

@Getter
public class DuplicatedProductNameException extends IllegalArgumentException {

    private ErrorCode errorCode;

    public DuplicatedProductNameException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}

