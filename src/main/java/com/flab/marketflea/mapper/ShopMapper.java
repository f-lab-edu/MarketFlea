package com.flab.marketflea.mapper;

import com.flab.marketflea.model.shop.Shop;
import com.flab.marketflea.model.shop.Shop.ShopStatus;
import com.flab.marketflea.model.shop.ShopOpenTimeInfo;
import com.flab.marketflea.model.shop.ShopRequest;
import com.flab.marketflea.model.shop.ShopResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopMapper {

    void createShop(Shop shop);
    boolean isShopExist(long shopId);
    ShopResponse getShopByShopId(long shopId);
    void updateShop(Shop shop);
    void deleteShop(long shopId, ShopRequest shopRequest);
    void updateShopStatus(@Param("id") long id, @Param("status") ShopStatus status);
    ShopOpenTimeInfo getShopSchedule(long id);

}
