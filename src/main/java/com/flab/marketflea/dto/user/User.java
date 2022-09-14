package com.flab.marketflea.dto.user;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class User {
    private String id;
    private String password;
    private String name;
    private Role role;
    private String phone;
    private String email;
    private String address;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
