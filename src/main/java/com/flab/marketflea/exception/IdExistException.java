package com.flab.marketflea.exception;

public class IdExistException extends RuntimeException{
    public IdExistException() {
        super("이미 존재하는 아이디입니다.");
    }
}
