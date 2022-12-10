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
        System.out.println(shop.getStatus());
        if (shop.getStatus() == ShopStatus.REQUESTED
            || shop.getStatus() == Shop.ShopStatus.REJECTED) {
            shopMapper.updateShopStatus(id, ShopStatus.APPROVED);
        } else {
            throw new InValidStatusException("InValidStatusException", ErrorCode.INVALID_SHOP_STATUS);
        }
    }

    @Override
    public void reject(long id) {
        ShopResponse shop = shopMapper.getShopByShopId(id);
        if (shop.getStatus() == ShopStatus.REQUESTED) {
            shopMapper.updateShopStatus(id, ShopStatus.REJECTED);
        } else {
            throw new InValidStatusException("InValidStatusException", ErrorCode.INVALID_SHOP_STATUS);
        }
    }

    @Override
    public void open(long id) {
        ShopResponse shop = shopMapper.getShopByShopId(id);
        if (shop.getStatus() == ShopStatus.APPROVED) {
            shopMapper.updateShopStatus(id, ShopStatus.OPENED);
        } else {
            throw new InValidStatusException("InValidStatusException", ErrorCode.INVALID_SHOP_STATUS);
        }
    }

    @Override
    public void close(long id) {
        ShopResponse shop = shopMapper.getShopByShopId(id);
        if (shop.getStatus() == ShopStatus.OPENED) {
            shopMapper.updateShopStatus(id, ShopStatus.CLOSED);
        } else {
            throw new InValidStatusException("InValidStatusException", ErrorCode.INVALID_SHOP_STATUS);
        }
    }
}
