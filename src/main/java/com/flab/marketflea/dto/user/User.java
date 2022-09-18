package com.flab.marketflea.dto.user;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class User {

    /*
    * Validation은 조금 더 공부 후 추가해보도록 하겠습니다.
    * */
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
