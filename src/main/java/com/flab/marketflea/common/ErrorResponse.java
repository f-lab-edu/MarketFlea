package com.flab.marketflea.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponse {

    public static final ResponseEntity<String> INVALID_SHOP_STATUS = new ResponseEntity<>("Shop 운영 상태를 확인해주세요.", HttpStatus.UNAUTHORIZED);

    public static final ResponseEntity<String> SHOP_NOT_FOUND =
            new ResponseEntity<>("해당 Shop을 찾을 수 없습니다.", HttpStatus.BAD_REQUEST);

    public static final ResponseEntity<String> USER_NOT_FOUND =
            new ResponseEntity<>(
                    "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.", HttpStatus.BAD_REQUEST
            );

    public static final ResponseEntity<String> WRONG_PASSWORD =
            new ResponseEntity<>("비밀번호를 확인해주세요.", HttpStatus.UNAUTHORIZED);

    public static final ResponseEntity<String> LOGIN_FAILED =
            new ResponseEntity<>("사용자가 존재하지 않거나 비밀번호가 틀렸습니다..", HttpStatus.UNAUTHORIZED);

    public static final ResponseEntity<String> ENCODER_FAILED_ERROR =
            new ResponseEntity<>("암호화 실패", HttpStatus.CONFLICT);

}

