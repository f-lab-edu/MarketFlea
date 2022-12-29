package com.flab.marketflea.exception;


import com.flab.marketflea.common.ErrorResponse;
import com.flab.marketflea.exception.product.DuplicatedProductException;
import com.flab.marketflea.exception.product.ProductNotFoundException;
import com.flab.marketflea.exception.shop.DuplicatedShopException;
import com.flab.marketflea.exception.shop.InValidStatusException;
import com.flab.marketflea.exception.shop.ShopNotFoundException;
import com.flab.marketflea.exception.user.EncoderNoSuchAlgorithmException;
import com.flab.marketflea.exception.user.UserNotFoundException;
import com.flab.marketflea.exception.user.WrongPasswordException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicatedShopException.class)
    protected ResponseEntity<ErrorResponse> handleDuplicatedShopException(DuplicatedShopException e) {
        log.debug("이미 존재하는 Shop 입니다.", e);
        ErrorResponse response = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(InValidStatusException.class)
    protected ResponseEntity<ErrorResponse> handleInValidStatusException(InValidStatusException e) {
        ErrorResponse response = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(ShopNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleShopNotFoundException(ShopNotFoundException e) {
        log.debug("해당 Shop 을 찾을 수 없습니다.", e);
        ErrorResponse response = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(EncoderNoSuchAlgorithmException.class)
    public final ResponseEntity<ErrorResponse> handleEncoderNoSuchAlgorithmException(EncoderNoSuchAlgorithmException e) {
        log.debug("암호화 실패", e);
        ErrorResponse response = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException e) {
        log.debug("해당 User 를 찾을 수 없습니다.", e);
        ErrorResponse response = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(WrongPasswordException.class)
    public final ResponseEntity<ErrorResponse> handleWrongPasswordException(WrongPasswordException e) {
        log.debug("비밀번호가 일치하지 않습니다.", e);
        ErrorResponse response = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(DuplicatedProductException.class)
    public final ResponseEntity<ErrorResponse> handleDuplicatedProductException(DuplicatedProductException e) {
        log.debug("중복된 상품입니다.", e);
        ErrorResponse response = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException e) {
        log.debug("해당 Product 를 찾을 수 없습니다.", e);
        ErrorResponse response = new ErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getErrorCode().getStatus()));
    }

}