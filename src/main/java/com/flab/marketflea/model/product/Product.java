package com.flab.marketflea.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @NotNull(message = "필수 입력값 입니다.")
    private long id;

    @NotNull(message = "필수 입력값 입니다.")
    private long shopId;

    @NotBlank(message = "필수 입력값 입니다.")
    private String productName;

    @NotBlank(message = "필수 입력값 입니다.")
    private Category category;

    @NotNull(message = "필수 입력값 입니다.")
    private int productQty;

    @NotNull(message = "필수 입력값 입니다.")
    private int price;

    @NotNull(message = "필수 입력값 입니다.")
    private LocalDate releaseDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
