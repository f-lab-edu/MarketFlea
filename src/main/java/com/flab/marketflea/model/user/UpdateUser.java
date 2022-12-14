package com.flab.marketflea.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UpdateUser {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String userId;

    private String name;

    private String phone;

    private String address;

    private String email;

    private LocalDateTime updatedAt;

}
