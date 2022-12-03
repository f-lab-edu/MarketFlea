package com.flab.marketflea.service.productservice;

import com.flab.marketflea.common.ErrorCode;
import com.flab.marketflea.exception.product.DuplicatedProductException;
import com.flab.marketflea.mapper.ProductMapper;
import com.flab.marketflea.model.product.ProductRequest;
import com.flab.marketflea.model.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductMapper productMapper;

    @Override
    public void addItem(ProductRequest requestDto) {
        productMapper.addItem(requestDto);
    }

    @Override
    public boolean isProductExist(long shopId, String productName) {
        if (productMapper.isProductIdExist(shopId, productName))
            throw new DuplicatedProductException("DuplicatedProductException", ErrorCode.PRODUCT_DUPLICATION);
        return false;
    }

    @Override
    public ProductResponse getProductByShopIdAndProductName(long shopId, String productName) {
        return productMapper.getProductByShopIdAndProductName(shopId, productName);

    }
}