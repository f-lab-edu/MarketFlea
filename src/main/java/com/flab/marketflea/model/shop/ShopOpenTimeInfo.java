package com.flab.marketflea.model.shop;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopOpenTimeInfo {

    private long id;

    private String shopName;

    private LocalDateTime shopOpenTime;

    private LocalDateTime shopCloseTime;

}
