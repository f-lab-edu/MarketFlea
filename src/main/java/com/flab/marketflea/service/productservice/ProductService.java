package com.flab.marketflea.service.productservice;

import com.flab.marketflea.model.product.ProductRequest;
import com.flab.marketflea.model.product.ProductResponse;

public interface ProductService {

    void addProduct(ProductRequest requestDto);
    ProductResponse getProductInfo(long id);
    void updateProduct(long id, ProductRequest product);
    void deleteProduct(long id);
}
