package com.flab.marketflea.service.productservice;

import com.flab.marketflea.model.product.ProductRequest;

public interface ProductService {

    void addItem(ProductRequest requestDto);

    boolean isProductExist(long shopId, String productName);

}
