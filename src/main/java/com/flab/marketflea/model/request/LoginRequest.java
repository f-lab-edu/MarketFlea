package com.flab.marketflea.model.request;

import com.flab.marketflea.model.user.Role;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class LoginRequest {

    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(max = 12, message = "최대 12자리까지 입력 가능합니다.")
    private String userId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(max = 20, message = "최대 20자리까지 입력 가능합니다.")
    private String password;

    public abstract Role getRole();
}