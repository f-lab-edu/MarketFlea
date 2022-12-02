package com.flab.marketflea.model.shop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopResponse {

    private long id;

    private String shopName;

    private String shopPhone;

    private Shop.ShopStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private LocalDateTime shopOpenTime;

    private LocalDateTime shopCloseTime;

}
