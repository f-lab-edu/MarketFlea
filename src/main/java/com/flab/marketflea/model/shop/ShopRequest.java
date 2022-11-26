package com.flab.marketflea.model.shop;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ShopRequest {

    @NotBlank(message = "SHOP 이름을 입력해주세요.")
    private String shopName;

    @NotBlank(message = "SHOP 전화번호를 입력해주세요.")
    private String shopPhone;

    @NotNull(message = "오픈 날짜와 시간을 입력해주세요.")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime shopOpenTime;

    @NotNull(message = "종료 날짜와 시간을 입력해주세요.")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime shopCloseTime;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    public Shop toEntity(long id) {
        return Shop.builder()
                .id(id)
                .shopName(this.shopName)
                .shopPhone(this.shopPhone)
                .shopOpenTime(this.shopOpenTime)
                .shopCloseTime(this.shopCloseTime)
                .createdAt(this.createdAt)
                .updatedAt(this.updatedAt)
                .build();
    }

}
