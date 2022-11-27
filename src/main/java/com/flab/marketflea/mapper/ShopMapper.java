package com.flab.marketflea.mapper;

import com.flab.marketflea.model.shop.Shop;
import com.flab.marketflea.model.shop.ShopResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopMapper {
    void createShop(Shop shop);

    boolean isShopExist(long shopId);

    ShopResponse getShopByShopId(long shopId);

    void updateShop(Shop shop);

    void deleteShop(long shopId);
}
