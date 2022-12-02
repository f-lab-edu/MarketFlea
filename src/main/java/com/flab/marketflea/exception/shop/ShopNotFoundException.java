package com.flab.marketflea.exception.shop;

import com.flab.marketflea.common.ErrorCode;
import lombok.Getter;

@Getter

public class ShopNotFoundException extends RuntimeException {
    private ErrorCode errorCode;

    public ShopNotFoundException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}