package com.flab.marketflea.controller;

import static com.flab.marketflea.common.ResponseEntityConstants.OK;
import static com.flab.marketflea.common.ResponseEntityConstants.UNAUTHORIZED;

import com.flab.marketflea.common.SessionService;
import com.flab.marketflea.model.product.ProductRequest;
import com.flab.marketflea.model.product.ProductResponse;
import com.flab.marketflea.service.productservice.ProductService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final SessionService sessionService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<Void> addProduct(@RequestBody @Valid ProductRequest requestDto) {
        boolean isLoginUser = sessionService.isLoginUser();
        if (!isLoginUser) {
            return UNAUTHORIZED;
        }
        productService.addProduct(requestDto);
        return OK;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductInfo(@PathVariable("id") long id) {
        ProductResponse productResponse = productService.getProductInfo(id);
        boolean isLoginUser = sessionService.isLoginUser();
        if (!isLoginUser) {
            return UNAUTHORIZED;
        }
        return ResponseEntity.ok(productResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable("id") long id,
        @Valid @RequestBody ProductRequest product) {
        boolean isLoginUser = sessionService.isLoginUser();
        if (!isLoginUser) {
            return UNAUTHORIZED;
        }
        productService.updateProduct(id, product);
        return OK;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") long id) {
        boolean isLoginUser = sessionService.isLoginUser();
        if (!isLoginUser) {
            return UNAUTHORIZED;
        }
        productService.deleteProduct(id);
        return OK;
    }

}
