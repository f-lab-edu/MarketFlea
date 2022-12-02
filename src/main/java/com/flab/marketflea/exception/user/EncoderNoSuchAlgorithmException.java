package com.flab.marketflea.exception.user;

import com.flab.marketflea.common.ErrorCode;
import lombok.Getter;

@Getter
public class EncoderNoSuchAlgorithmException extends RuntimeException {
    private ErrorCode errorCode;

    public EncoderNoSuchAlgorithmException(String message, ErrorCode errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
