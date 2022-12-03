package com.flab.marketflea.mapper;

import com.flab.marketflea.model.product.ProductRequest;
import com.flab.marketflea.model.product.ProductResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    void addItem(ProductRequest product);

    boolean isProductIdExist(long shopId, String productName);

    ProductResponse getProductByShopIdAndProductName(long shopId, String productName);

}
