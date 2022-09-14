package com.flab.marketflea.dto.user;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ADMIN,
    MERCHANDISER,
    CUSTOMER
}
