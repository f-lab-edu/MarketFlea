package com.flab.marketflea.model.seller;

import com.flab.marketflea.model.user.Role;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SellerRequest {

    private long id;

    @NotBlank(message = "id 를 입력해주세요. ")
    private String userId;

    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;

    @NotBlank(message = "이름은 필수 입력값입니다.")
    private String name;

    private Role role;

    @NotBlank(message = "Shop 이름은 필수 입력값입니다.")
    private String shopName;

    @NotBlank(message = "전화번호는 필수 입력값입니다.")
    private String phone;

    @NotBlank(message = "이메일은 필수 입력값입니다.")
    private String email;

    @NotBlank(message = "주소는 필수 입력값입니다.")
    private String address;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Seller toEntity(long id) {
        return Seller.builder()
            .id(id)
            .name(this.name)
            .phone(this.phone)
            .shopName(this.shopName)
            .email(this.email)
            .address(this.address)
            .createdAt(this.createdAt)
            .updatedAt(this.updatedAt)
            .build();
    }
}
