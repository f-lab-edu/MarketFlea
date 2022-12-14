package com.flab.marketflea.controller;

import static com.flab.marketflea.common.ResponseEntityConstants.*;

import com.flab.marketflea.common.SessionService;
import com.flab.marketflea.model.product.ProductRequest;
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
    public void addItem(@RequestBody @Valid ProductRequest requestDto) {
        productService.addProduct(requestDto);
    }

    @GetMapping("/{productName}/duplicate")
    public ResponseEntity<Void> isIdDuplicated(@PathVariable String productName) {
        boolean isIdDuplicated = productService.isProductExist(productName);
        if (isIdDuplicated) {
            return CONFLICT;
        } else {
            return OK;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable("id") long id, @Valid @RequestBody ProductRequest product) {
        boolean isLoginUser = sessionService.isLoginUser();
        if (!isLoginUser) {
            return UNAUTHORIZED;
        }
        productService.updateProduct(id, product);
        return OK;
    }

    @DeleteMapping("/{productName}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productName") String productName, @RequestBody ProductRequest product) {

        boolean isLoginUser = sessionService.isLoginUser();
        if(!isLoginUser) {
            return UNAUTHORIZED;
        }
        productService.deleteProduct(productName, product);
        return OK;
    }

}