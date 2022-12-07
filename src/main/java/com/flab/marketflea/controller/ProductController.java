package com.flab.marketflea.controller;

import static com.flab.marketflea.common.ResponseEntityConstants.CONFLICT;
import static com.flab.marketflea.common.ResponseEntityConstants.OK;

import com.flab.marketflea.model.product.ProductRequest;
import com.flab.marketflea.service.productservice.ProductService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void addItem(@RequestBody @Valid ProductRequest requestDto) {
        productService.addItem(requestDto);
    }


    @GetMapping("/{productId}/duplicate")
    public ResponseEntity<Void> isIdDuplicated(@PathVariable long productId) {
        boolean isIdDuplicated = productService.validateProduct(productId);
        if (isIdDuplicated) {
            return CONFLICT;
        }
        return OK;
    }
}