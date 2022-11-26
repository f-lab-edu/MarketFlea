package com.flab.marketflea.controller;


import com.flab.marketflea.common.SessionService;
import com.flab.marketflea.model.shop.ShopRequest;
import com.flab.marketflea.service.shopservice.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.flab.marketflea.common.ResponseEntityConstants.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shops")
public class ShopController {


    private final ShopService shopService;
    private final SessionService sessionService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("shops")
    public void crateShop(@RequestBody ShopRequest shop) {
        shopService.createShop(shop);
    }

    @GetMapping("/{shopId}/duplicate")
    public ResponseEntity<Void> isIdDuplicated(@PathVariable long shopId) {
        boolean isIdDuplicated = shopService.isShopExist(shopId);
        if (isIdDuplicated) {
            return CONFLICT;
        } else {
            return OK;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateShop(@PathVariable("id") long id , @Valid @RequestBody ShopRequest shop) {
        boolean isLoginUser = sessionService.isLoginUser();

        if (!isLoginUser) {
            return UNAUTHORIZED;
        }
        shopService.updateShop(id, shop);

        return OK;
    }

}
