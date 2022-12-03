package com.flab.marketflea.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class ProductResponse {

    private long id;
    private long shopId;
    private String productName;
    private Category category;
    private int productQty;
    private int price;
    private LocalDate releaseDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
