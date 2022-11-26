package com.flab.marketflea.model.shop;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Shop {

    public enum ShopStatus{
        REQUEST,
        APPROVE,
        REJECT,
        OPEN,
        CLOSE
    }

    @NotNull(message = "필수 입력값 입니다.")
    private long id;

    @NotBlank(message = "SHOP 이름을 입력해주세요.")
    private String shopName;

    @NotBlank(message = "SHOP 전화번호를 입력해주세요.")
    private String shopPhone;

    @NotNull
    private ShopStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @NotNull(message = "오픈 날짜와 시간을 입력해주세요.")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime shopOpenTime;

    @NotNull(message = "종료 날짜와 시간을 입력해주세요.")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime shopCloseTime;


}
