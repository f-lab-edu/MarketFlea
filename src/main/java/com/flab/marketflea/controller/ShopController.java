package com.flab.marketflea.controller;


import static com.flab.marketflea.common.ResponseEntityConstants.CONFLICT;
import static com.flab.marketflea.common.ResponseEntityConstants.OK;
import static com.flab.marketflea.common.ResponseEntityConstants.UNAUTHORIZED;

import com.flab.marketflea.common.SessionService;
import com.flab.marketflea.model.shop.ShopRequest;
import com.flab.marketflea.service.shopservice.ShopService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class ShopController {

    private final ShopService shopService;
    private final SessionService sessionService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void crateShop(@RequestBody ShopRequest shop) {
        shopService.createShop(shop);
    }

    @GetMapping("/{shopId}/duplicate")
    public ResponseEntity<Void> isIdDuplicated(@PathVariable long shopId) {
        boolean isIdDuplicated = shopService.isShopExist(shopId);
        if (isIdDuplicated) {
            return CONFLICT;
        }
        return OK;
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> updateShop(@PathVariable("id") long id,
        @Valid @RequestBody ShopRequest shop) {
        boolean isLoginUser = sessionService.isLoginUser();
        if (!isLoginUser) {
            return UNAUTHORIZED;
        }
        shopService.updateShop(id, shop);
        return OK;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable("id") long id, ShopRequest shopRequest) {

        boolean isLoginUser = sessionService.isLoginUser();
        if (!isLoginUser) {
            return UNAUTHORIZED;
        }
        shopService.deleteShop(id, shopRequest);
        return OK;
    }

}