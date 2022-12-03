package com.flab.marketflea.exception.product;

import com.flab.marketflea.common.ErrorCode;
import lombok.Getter;

@Getter
public class DuplicatedProductException extends IllegalArgumentException {

    private ErrorCode errorCode;

    public DuplicatedProductException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}

