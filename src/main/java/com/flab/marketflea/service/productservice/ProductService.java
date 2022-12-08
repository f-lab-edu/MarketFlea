package com.flab.marketflea.service.productservice;

import com.flab.marketflea.model.product.ProductRequest;
import com.flab.marketflea.model.product.ProductResponse;

public interface ProductService {

    void addItem(ProductRequest requestDto);
    boolean isProductExist(long productId);
    ProductResponse getProductById(long productId);
    void updateProduct(long id, ProductRequest product);
    void deleteProduct(long id, ProductRequest product);
}
