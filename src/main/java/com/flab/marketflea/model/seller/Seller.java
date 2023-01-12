package com.flab.marketflea.model.seller;

import com.flab.marketflea.model.user.Role;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Seller {

    private long id;

    private String userId;

    private String password;

    private String name;

    private Role role;

    private String shopName;

    private String phone;

    private String email;

    private String address;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
