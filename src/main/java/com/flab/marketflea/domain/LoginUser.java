package com.flab.marketflea.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@Builder
@ToString
public class LoginUser {

    @NonNull
    private String id;

    @NonNull
    private String password;

}
