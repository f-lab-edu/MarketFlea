package com.flab.marketflea.model.product;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProductRequest {

    @NotNull
    private long shopId;

    @NotBlank(message = "상품명을 입력해주세요.")
    private String productName;

    @NotNull(message = "카테고리를 등록해주세요.")
    private Category category;

    @NotNull(message = "상품 수량을 입력해주세요.")
    private int productQty;

    @NotNull(message = "가격을 입력해주세요.")
    private int price;

    @NotNull(message = "샵 오픈 날짜를 입력해주세요.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    public Product toEntity(long id) {
        return Product.builder()
                .id(id)
                .shopId(this.shopId)
                .productName(this.productName)
                .category(this.category)
                .productQty(this.productQty)
                .price(this.price)
                .releaseDate(this.releaseDate)
                .build();
    }
}

