package com.flab.marketflea.dto.user;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class User {

    @NotNull
    private String id;

    @NotNull
    @Size(min = 8, max = 30, message = "비밀번호는 최소 6자리부터 최대 30자리여야합니다.")
    private String password;

    @NotNull
    private String name;

    @NotNull
    private Role role;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    @NotNull
    private String address;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
