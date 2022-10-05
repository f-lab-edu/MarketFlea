package com.flab.marketflea.domain;

import lombok.*;

@Getter
@Builder
@ToString
public class LoginUser {

    private String id;

    private String password;

}
