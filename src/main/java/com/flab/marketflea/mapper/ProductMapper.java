package com.flab.marketflea.mapper;

import com.flab.marketflea.model.product.ProductResponse;
import com.flab.marketflea.model.product.ProductRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    void addItem(ProductRequest product);
    boolean checkDuplicateProductName(String productName);
    ProductResponse findById(long id);
    boolean isProductExist(long id);

}
