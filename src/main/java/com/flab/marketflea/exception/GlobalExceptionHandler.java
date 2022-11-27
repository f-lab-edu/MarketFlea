package com.flab.marketflea.exception;


import com.flab.marketflea.exception.shop.DuplicatedShopException;
import com.flab.marketflea.exception.shop.InValidStatusException;
import com.flab.marketflea.exception.shop.ShopNotFoundException;
import com.flab.marketflea.exception.user.EncoderNoSuchAlgorithmException;
import com.flab.marketflea.exception.user.LoginFailedException;
import com.flab.marketflea.exception.user.UserNotFoundException;
import com.flab.marketflea.exception.user.WrongPasswordException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.flab.marketflea.common.ErrorResponse.*;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(DuplicatedShopException.class)
    public final ResponseEntity<String> DuplicatedShopException(DuplicatedShopException e) {
        log.debug("이미 존재하는 Shop 입니다.", e);
        return INVALID_SHOP_STATUS;
    }

    @ExceptionHandler(InValidStatusException.class)
    public final ResponseEntity<String> InValidStatusException(InValidStatusException e) {
        log.debug("Shop 운영 상태를 확인해주세요.", e);
        return INVALID_SHOP_STATUS;
    }

    @ExceptionHandler(ShopNotFoundException.class)
    public final ResponseEntity<String> ShopNotFoundException(ShopNotFoundException e) {
        log.debug("해당 Shop 을 찾을 수 없습니다.", e);
        return SHOP_NOT_FOUND;
    }

    @ExceptionHandler(EncoderNoSuchAlgorithmException.class)
    public final ResponseEntity<String> EncoderNoSuchAlgorithmException(EncoderNoSuchAlgorithmException e) {
        log.debug("암호화 실패", e);
        return ENCODER_FAILED_ERROR;
    }

    @ExceptionHandler(LoginFailedException.class)
    public final ResponseEntity<String> LoginFailedException(LoginFailedException e) {
        log.debug("사용자가 존재하지 않거나 비밀번호가 틀렸습니다.", e);
        return LOGIN_FAILED;
    }

    @ExceptionHandler(ShopNotFoundException.class)
    public final ResponseEntity<String> UserNotFoundException(UserNotFoundException e) {
        log.debug("해당 User 를 찾을 수 없습니다.", e);
        return USER_NOT_FOUND;
    }

    @ExceptionHandler(WrongPasswordException.class)
    public final ResponseEntity<String> WrongPasswordException(WrongPasswordException e) {
        log.debug("비밀번호가 일치하지 않습니다.", e);
        return WRONG_PASSWORD;
    }

}