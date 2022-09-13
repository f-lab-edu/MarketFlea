package com.flab.marketflea.dto.user;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

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

}
