package com.flab.marketflea.mapper;

import com.flab.marketflea.model.product.ProductRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    void addItem(ProductRequest product);
    boolean isProductExist(long productId);

}
