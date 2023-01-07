package com.flab.marketflea.mapper.param;

import com.flab.marketflea.model.user.Role;
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
public class UserInfoParam {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String userId;

    private String password;

    private String name;

    private Role role;

    private String phone;

    private String email;

    private String address;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
