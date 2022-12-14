package com.flab.marketflea.mapper;

import com.flab.marketflea.model.product.Product;
import com.flab.marketflea.model.product.ProductRequest;
import com.flab.marketflea.model.product.ProductResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    void addProduct(ProductRequest product);

    boolean isProductNameExist(String productName);

    ProductResponse getProductById(long productId);

    void updateProduct(Product product);

    void deleteProduct(long id);
}
