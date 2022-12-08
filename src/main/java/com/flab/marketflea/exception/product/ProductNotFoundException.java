package com.flab.marketflea.exception.product;

import com.flab.marketflea.common.ErrorCode;
import lombok.Getter;

@Getter
public class ProductNotFoundException extends IllegalArgumentException {

    private ErrorCode errorCode;

    public ProductNotFoundException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}