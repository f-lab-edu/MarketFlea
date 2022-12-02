package com.flab.marketflea.service.shopservice;

import com.flab.marketflea.model.shop.ShopRequest;
import com.flab.marketflea.model.shop.ShopResponse;

public interface ShopService {
    void createShop(ShopRequest shop);

    boolean isShopExist(long shopId);

    ShopResponse getShopByShopId(long shopId);

    void updateShop(long id, ShopRequest shop);

    void deleteShop(long id);
}
