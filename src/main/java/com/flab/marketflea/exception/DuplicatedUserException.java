package com.flab.marketflea.exception;

public class DuplicatedUserException extends RuntimeException {
    public DuplicatedUserException(String msg) {
        super(msg);
    }
}