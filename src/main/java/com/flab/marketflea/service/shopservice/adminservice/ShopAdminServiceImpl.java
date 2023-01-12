package com.flab.marketflea.service.shopservice.adminservice;

import com.flab.marketflea.common.ErrorCode;
import com.flab.marketflea.exception.shop.InValidStatusException;
import com.flab.marketflea.mapper.ShopMapper;
import com.flab.marketflea.model.shop.Shop;
import com.flab.marketflea.model.shop.Shop.ShopStatus;
import com.flab.marketflea.model.shop.ShopResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ShopAdminServiceImpl implements ShopAdminService {

    private final ShopMapper shopMapper;

    @Override
    public void approve(long id) {
        ShopResponse shop = shopMapper.getShopByShopId(id);
        if (shop.getStatus() != ShopStatus.REQUESTED
            || shop.getStatus() != Shop.ShopStatus.REJECTED) {
            throw new InValidStatusException("InValidStatusException",
                ErrorCode.INVALID_SHOP_STATUS);
        }
        shopMapper.updateShopStatus(id, ShopStatus.APPROVED);
    }


    @Override
    public void reject(long id) {
        ShopResponse shop = shopMapper.getShopByShopId(id);
        if (shop.getStatus() != ShopStatus.REQUESTED) {
            throw new InValidStatusException("InValidStatusException",
                ErrorCode.INVALID_SHOP_STATUS);
        }
        shopMapper.updateShopStatus(id, ShopStatus.REJECTED);
    }

    @Override
    public void open(long id) {
        ShopResponse shop = shopMapper.getShopByShopId(id);
        if (shop.getStatus() != ShopStatus.APPROVED) {
            throw new InValidStatusException("InValidStatusException",
                ErrorCode.INVALID_SHOP_STATUS);
        }
        shopMapper.updateShopStatus(id, ShopStatus.OPENED);
    }


    @Override
    public void close(long id) {
        ShopResponse shop = shopMapper.getShopByShopId(id);
        if (shop.getStatus() != ShopStatus.OPENED) {
            throw new InValidStatusException("InValidStatusException",
                ErrorCode.INVALID_SHOP_STATUS);
        }
        shopMapper.updateShopStatus(id, ShopStatus.CLOSED);
    }
}
