package com.flab.marketflea.dto.user;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN("관리자", "admin"),
    MERCHANDISER("판매자", "merchandise"),
    CUSTOMER("구매자", "customer");

    @JsonValue
   private String korean;
   private String english;
}
