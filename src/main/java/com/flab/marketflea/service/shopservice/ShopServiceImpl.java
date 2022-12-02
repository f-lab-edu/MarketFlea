package com.flab.marketflea.service.shopservice;

import com.flab.marketflea.common.ErrorCode;
import com.flab.marketflea.exception.shop.DuplicatedShopException;
import com.flab.marketflea.exception.shop.InValidStatusException;
import com.flab.marketflea.exception.shop.ShopNotFoundException;
import com.flab.marketflea.mapper.ShopMapper;
import com.flab.marketflea.model.shop.Shop;
import com.flab.marketflea.model.shop.ShopRequest;
import com.flab.marketflea.model.shop.ShopResponse;
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
                .shopName(shop.getShopName())
                .shopPhone(shop.getShopPhone())
                .status(Shop.ShopStatus.REQUEST)
                .shopOpenTime(shop.getShopOpenTime())
                .shopCloseTime(shop.getShopCloseTime())
                .createdAt(shop.getCreatedAt())
                .updatedAt(shop.getUpdatedAt())
                .build();

        shopMapper.createShop(createdShop);
    }


    @Override
    public boolean isShopExist(long shopId) {
        if(shopMapper.isShopExist(shopId))
            throw new DuplicatedShopException("DuplicatedShopException", ErrorCode.EMAIL_DUPLICATION);
        return false;
    }

    @Override
    public ShopResponse getShopByShopId(long shopId) {
        return shopMapper.getShopByShopId(shopId);
    }


    @Override
    @Transactional
    public void updateShop(long id, ShopRequest shop) {
        Shop.ShopStatus shopStatus = getShopByShopId(id).getStatus();
        if (shopStatus == Shop.ShopStatus.REQUEST || shopStatus == Shop.ShopStatus.OPEN)
            throw new InValidStatusException("InValidStatusException", ErrorCode.INVALID_SHOP_STATUS);
        shopMapper.updateShop(shop.toEntity(id));
    }

    @Override
    @Transactional
    public void deleteShop(long id) {
        if (!shopMapper.isShopExist(id)) {
            throw new ShopNotFoundException("ShopNotFoundException", ErrorCode.SHOP_NOT_FOUND);
        }
        shopMapper.deleteShop(id);

    }
}
