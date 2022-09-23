package com.flab.marketflea.dto.user;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Builder
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
