package com.flab.marketflea.service.productservice;

import com.flab.marketflea.model.product.ProductResponse;
import com.flab.marketflea.model.product.ProductRequest;

public interface ProductService {

    void addProduct(ProductRequest requestDto);
    ProductResponse getProductInfo(long id);
}
