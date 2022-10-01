package com.flab.marketflea.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;

@Getter
@Builder

public class User {

    @NonNull
    private String id;

    @NonNull
    private String password;

    @NonNull
    private String name;

    private Role role;

    @NonNull
    private String phone;

    @NonNull
    private String email;

    @NonNull
    private String address;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void setPassword(String password) {
        this.password = password;
    }
}
