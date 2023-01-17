package com.flab.marketflea.service.shopservice;

import com.flab.marketflea.model.shop.ShopOpenTimeInfo;
import com.flab.marketflea.model.shop.ShopRequest;
import com.flab.marketflea.model.shop.ShopResponse;
import org.springframework.stereotype.Service;

@Service
public interface ShopService {

    void createShop(ShopRequest shop);

    boolean isShopExist(long shopId);

    ShopResponse getShopByShopId(long shopId);

    void updateShop(long id, ShopRequest shop);

    void deleteShop(long id, ShopRequest shop);

    ShopOpenTimeInfo CheckShopSchedule(long id);
}
