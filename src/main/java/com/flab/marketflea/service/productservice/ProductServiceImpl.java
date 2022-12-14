package com.flab.marketflea.service.productservice;

import com.flab.marketflea.common.ErrorCode;
import com.flab.marketflea.exception.product.DuplicatedProductNameException;
import com.flab.marketflea.exception.product.ProductNotFoundException;
import com.flab.marketflea.mapper.ProductMapper;
import com.flab.marketflea.model.product.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    @Override
    @Transactional
    public void addProduct(ProductRequest requestDto) {
        if (productMapper.isProductNameExist(requestDto.getProductName())) {
            throw new DuplicatedProductNameException("DuplicatedProductNameException",
                ErrorCode.PRODUCT_DUPLICATION);
        }
        productMapper.addProduct(requestDto);
    }

    @Override
    @Transactional
    public void updateProduct(long id, ProductRequest product) {
        if (productMapper.isProductNameExist(product.getProductName())) {
            throw new DuplicatedProductNameException("DuplicatedProductNameException",
                ErrorCode.PRODUCT_DUPLICATION);
        }
        productMapper.updateProduct(product.toEntity(id));
    }

    @Override
    @Transactional
    public void deleteProduct(long id) {
        if (productMapper.getProductById(id) == null) {
            throw new ProductNotFoundException("ProductNotFoundException",
                ErrorCode.PRODUCT_NOT_FOUND);
        }
        productMapper.deleteProduct(id);
    }
}