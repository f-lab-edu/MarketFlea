package com.flab.marketflea.mapper;

import com.flab.marketflea.model.product.Product;
import com.flab.marketflea.model.product.ProductRequest;
import com.flab.marketflea.model.product.ProductResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    void addProduct(ProductRequest product);
    boolean checkDuplicateProductName(String productName);
    ProductResponse findById(long id);
    boolean isProductExist(long id);
    void updateProduct(Product product);
    void deleteProduct(long id);
}
