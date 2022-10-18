package com.flab.marketflea.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor

public class UpdatePasswordUser {
    private  final String userId;

    private final String existPassword;

    private final String newPassword;

    private final String checkNewPassword;

}
