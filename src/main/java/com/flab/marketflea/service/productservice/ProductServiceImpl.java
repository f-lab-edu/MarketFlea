package com.flab.marketflea.service.productservice;

import com.flab.marketflea.common.ErrorCode;
import com.flab.marketflea.exception.product.DuplicatedProductNameException;
import com.flab.marketflea.exception.product.ProductNotFoundException;
import com.flab.marketflea.mapper.ProductMapper;
import com.flab.marketflea.model.product.ProductRequest;
import com.flab.marketflea.model.product.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductMapper productMapper;

    @Override
    public void addProduct(ProductRequest requestDto) {
        if(isProductNameExist(requestDto.getProductName()))
            throw new DuplicatedProductNameException("DuplicatedProductNameException", ErrorCode.PRODUCT_DUPLICATION);
        productMapper.addProduct(requestDto);
    }

    @Override
    public boolean isProductNameExist(String productName) {
        if (productMapper.isProductNameExist(productName))
            throw new DuplicatedProductNameException("DuplicatedProductNameException", ErrorCode.PRODUCT_DUPLICATION);
        return false;
    }

    @Override
    public ProductResponse getProductById(long productId) {
        return productMapper.getProductById(productId);
    }

    @Override
    @Transactional
    public void updateProduct(long id, ProductRequest product) {
        productMapper.updateProduct(product.toEntity(id));
    }

    @Override
    @Transactional
    public void deleteProduct(long id) {
        if (getProductById(id) == null) {
            throw new ProductNotFoundException("ProductNotFoundException", ErrorCode.PRODUCT_NOT_FOUND);
        }
        productMapper.deleteProduct(id);
    }
}