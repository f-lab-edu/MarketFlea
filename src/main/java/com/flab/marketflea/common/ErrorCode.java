package com.flab.marketflea.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {


    // 400 BAD_REQUEST 잘못된 요청
    INVALID_SHOP_STATUS(400, "Shop 운영 상태를 확인해주세요."),
    WRONG_PASSWORD(400, "비밀번호를 확인해주세요. "),
    EMAIL_DUPLICATION(400, "중복된 Email 입니다."),
    SHOP_DUPLICATION(400, "중복된 Shop 입니다."),

    // 404 NOT_FOUND 잘못된 리소스 접근
    SHOP_NOT_FOUND (404, "해당 Shop 을 찾을 수 없습니다. "),
    USER_NOT_FOUND(404, "가입하지 않은 아이디거나, 잘못된 비밀번호 입니다."),

    // 409 CONFLICT 중복된 리소스

    // 500 INTERNAL_SERVER_ERROR
    ENCODER_FAILED_ERROR(500, "암호화 실패했습니다. "),
    INTERNAL_SERVER_ERROR(500, "서버 에러입니다.");

    private final int status;
    private final String message;



//    ErrorCode(final int status, final String message){
//        this.status = status;
//        this.message = message;
//    }
}
