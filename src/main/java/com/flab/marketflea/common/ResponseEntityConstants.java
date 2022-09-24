package com.flab.marketflea.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityConstants {

    public static final ResponseEntity<HttpStatus> RESPONSE_ENTITY_CONFLICT = ResponseEntity.status(HttpStatus.CONFLICT).build();
    public static final ResponseEntity<HttpStatus> RESPONSE_ENTITY_OK = ResponseEntity.status(HttpStatus.OK).build();
}