package com.flab.marketflea.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UpdatePasswordUser {

    private String userId;

    private String existPassword;

    private String newPassword;

    private String checkNewPassword;

}
