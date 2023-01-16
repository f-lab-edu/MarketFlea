package com.flab.marketflea.model.shop;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopOpenTimeRequest {

    private long id;

    @NotBlank(message = "SHOP 이름을 입력해주세요.")
    private String shopName;

}
