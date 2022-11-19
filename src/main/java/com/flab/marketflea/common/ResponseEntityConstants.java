package com.flab.marketflea.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityConstants {

    public static final ResponseEntity OK = new ResponseEntity(HttpStatus.OK);
    public static final ResponseEntity CREATED = new ResponseEntity(HttpStatus.CREATED);
    public static final ResponseEntity CONFLICT = new ResponseEntity(HttpStatus.CONFLICT);
    public static final ResponseEntity UNAUTHORIZED = new ResponseEntity(HttpStatus.UNAUTHORIZED);

}
