package com.flab.marketflea.service.shopservice;

import com.flab.marketflea.common.ErrorCode;
import com.flab.marketflea.exception.shop.DuplicatedShopException;
import com.flab.marketflea.exception.shop.InValidStatusException;
import com.flab.marketflea.exception.shop.ShopNotFoundException;
import com.flab.marketflea.mapper.ShopMapper;
import com.flab.marketflea.model.shop.Shop;
import com.flab.marketflea.model.shop.Shop.ShopStatus;
import com.flab.marketflea.model.shop.ShopOpenTimeInfo;
import com.flab.marketflea.model.shop.ShopRequest;
import com.flab.marketflea.model.shop.ShopResponse;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopMapper shopMapper;


    @Override
    public void createShop(ShopRequest shop) {

        Shop createdShop = Shop.builder()
            .id(0)
            .shopName(shop.getShopName())
            .shopPhone(shop.getShopPhone())
            .status(Shop.ShopStatus.REQUESTED)
            .shopOpenTime(shop.getShopOpenTime())
            .shopCloseTime(shop.getShopCloseTime())
            .createdAt(shop.getCreatedAt())
            .updatedAt(shop.getUpdatedAt())
            .build();

        shopMapper.createShop(createdShop);
    }


    @Override
    public boolean isShopExist(long shopId) {
        if (shopMapper.isShopExist(shopId)) {
            throw new DuplicatedShopException("DuplicatedShopException", ErrorCode.EMAIL_DUPLICATION);
        }
        if (shopMapper.isShopExist(shopId)) {
            throw new DuplicatedShopException("DuplicatedShopException",
                ErrorCode.EMAIL_DUPLICATION);
        }
        return false;
    }

    @Override
    public ShopResponse getShopByShopId(long shopId) {
        ShopResponse shop = shopMapper.getShopByShopId(shopId);
        return shop;
    }

    @Override
    @Transactional
    public void updateShop(long id, ShopRequest shop) {
        Shop.ShopStatus shopStatus = getShopByShopId(id).getStatus();
        if (shopStatus == ShopStatus.REQUESTED || shopStatus == Shop.ShopStatus.OPENED) {
            throw new InValidStatusException("InValidStatusException",
                ErrorCode.INVALID_SHOP_STATUS);
        }
        shopMapper.updateShop(shop.toEntity(id));
    }

    @Override
    @Transactional
    public void deleteShop(long id, ShopRequest shop) {
        if (!shopMapper.isShopExist(id)) {
            throw new ShopNotFoundException("ShopNotFoundException", ErrorCode.SHOP_NOT_FOUND);
        }
        shopMapper.deleteShop(id,shop);
    }

    @Override
    @Transactional
    public ShopOpenTimeInfo CheckShopSchedule(long id) {

        Shop.ShopStatus shopStatus = shopMapper.getShopByShopId(id).getStatus();
        LocalDateTime currentDate = LocalDateTime.now();
        if (shopStatus != ShopStatus.APPROVED) {
            throw new InValidStatusException("InValidStatusException", ErrorCode.INVALID_SHOP_STATUS);
        }
        if (!shopMapper.isShopExist(id)) {
            throw new ShopNotFoundException("ShopNotFoundException", ErrorCode.SHOP_NOT_FOUND);
        }
        if (currentDate.isAfter(getShopByShopId(id).getShopOpenTime())) {
            throw new InValidStatusException("InValidStatusException", ErrorCode.INVALID_SHOP_STATUS);
        }
        return shopMapper.checkShopSchedule(id);
    }

}
