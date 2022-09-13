package com.flab.marketflea.user;

import lombok.Data;

@Data
public class User {
    private String id;
    private String password;
    private String name;
    private Role role;
    private String phone;
    private String email;
    private String address;

}
