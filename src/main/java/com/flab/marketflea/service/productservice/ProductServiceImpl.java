package com.flab.marketflea.service.productservice;

import com.flab.marketflea.common.ErrorCode;
import com.flab.marketflea.exception.product.DuplicatedProductNameException;
import com.flab.marketflea.exception.product.ProductNotFoundException;
import com.flab.marketflea.mapper.ProductMapper;
import com.flab.marketflea.model.product.ProductResponse;
import com.flab.marketflea.model.product.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductMapper productMapper;

    @Override
    public void addProduct(ProductRequest requestDto) {
        if(productMapper.checkDuplicateProductName(requestDto.getProductName()))
            throw new  DuplicatedProductNameException("DuplicatedProductNameException", ErrorCode.PRODUCT_DUPLICATION);
        productMapper.addItem(requestDto);
    }

    @Override
    public ProductResponse getProductInfo(long id) {
        if(!productMapper.isProductExist(id))
            throw new ProductNotFoundException("ProductNotFoundException", ErrorCode.PRODUCT_NOT_FOUND);
        return productMapper.findById(id);
    }
}