package com.flab.marketflea.service.userservice.command;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateCommand {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String userId;

    private String name;

    private String phone;

    private String address;

    private String email;

    private LocalDateTime updatedAt;
}
