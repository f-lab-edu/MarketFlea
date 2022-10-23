package com.flab.marketflea.model;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class LoginUser {

    private String userId;

    private String password;

}
