package com.flab.marketflea.service.productservice;

import com.flab.marketflea.model.product.ProductRequest;

public interface ProductService {

    void addProduct(ProductRequest requestDto);
    void updateProduct(long id, ProductRequest product);
    void deleteProduct(long id);
}
