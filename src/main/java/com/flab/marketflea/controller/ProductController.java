package com.flab.marketflea.controller;

import com.flab.marketflea.model.product.ProductRequest;
import com.flab.marketflea.service.productservice.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.flab.marketflea.common.ResponseEntityConstants.CONFLICT;
import static com.flab.marketflea.common.ResponseEntityConstants.OK;


@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void crateShop(@RequestBody ProductRequest requestDto) {
        productService.addItem(requestDto);
    }

    @GetMapping("/{shopId}/duplicate")
    public ResponseEntity<Void> addItem(@RequestBody @Valid ProductRequest requestDto) {
        boolean isIdDuplicated = productService.isProductExist(requestDto.getShopId(), requestDto.getProductName());
        if (isIdDuplicated) {
            return CONFLICT;
        } else {
            return OK;
        }

    }
}