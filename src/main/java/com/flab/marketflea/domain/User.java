package com.flab.marketflea.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private String id;

    private String password;

    private String name;

    private Role role;

    private String phone;

    private String email;

    private String address;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
