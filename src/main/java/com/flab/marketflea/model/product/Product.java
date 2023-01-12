package com.flab.marketflea.model.product;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @NotNull
    private long id;

    @NotNull
    private long shopId;

    @Length(max = 45)
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

}
