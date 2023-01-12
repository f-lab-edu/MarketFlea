package com.flab.marketflea.mapper;

import com.flab.marketflea.model.seller.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SellerMapper {

    void signUp(Seller seller);

    boolean isShopNameExist(String shopName);

    boolean isIdExist(String userId);

    Seller findByIdAndPassword(@Param ("userId") String userId, @Param ("password") String password);

    Seller getSellerById(String id);

    void update(Seller seller);

    void updatePassword(Seller seller);

    void deleteSeller(Seller seller);
}
