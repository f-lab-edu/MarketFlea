package com.flab.marketflea.service.productservice;

import com.flab.marketflea.common.ErrorCode;
import com.flab.marketflea.exception.product.DuplicatedProductException;
import com.flab.marketflea.exception.product.ProductNotFoundException;
import com.flab.marketflea.mapper.ProductMapper;
import com.flab.marketflea.model.product.ProductRequest;
import com.flab.marketflea.model.product.ProductResponse;
import com.flab.marketflea.service.shopservice.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductMapper productMapper;
    private final ShopService shopService;

    @Override
    public void addProduct(ProductRequest requestDto) {
        productMapper.addItem(requestDto);
    }

    @Override
    public boolean isProductExist(long productId) {
        if (productMapper.isProductExist(productId))
            throw new DuplicatedProductException("DuplicatedProductException", ErrorCode.PRODUCT_DUPLICATION);
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
    public void deleteProduct(long id, ProductRequest product) {
        if (!productMapper.isProductExist(id)) {
            throw new ProductNotFoundException("ProductNotFoundException", ErrorCode.PRODUCT_NOT_FOUND);
        }
        productMapper.deleteProduct(id);

    }
}