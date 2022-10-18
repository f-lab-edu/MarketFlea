package com.flab.marketflea.domain;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class LoginUser {


    private String userId;

    private String password;

}
