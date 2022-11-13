package com.flab.marketflea.model.user;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UpdateUser {

    private String userId;

    private String name;

    private String phone;

    private String address;

    private String email;

    private LocalDateTime updatedAt;

}
