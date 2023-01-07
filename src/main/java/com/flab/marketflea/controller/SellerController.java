package com.flab.marketflea.controller;


import static com.flab.marketflea.common.ResponseEntityConstants.CONFLICT;
import static com.flab.marketflea.common.ResponseEntityConstants.OK;
import static com.flab.marketflea.common.ResponseEntityConstants.UNAUTHORIZED;

import com.flab.marketflea.common.SessionService;
import com.flab.marketflea.model.seller.Seller;
import com.flab.marketflea.model.seller.SellerLoginRequest;
import com.flab.marketflea.model.seller.SellerRequest;
import com.flab.marketflea.model.seller.UpdatePasswordSeller;
import com.flab.marketflea.service.loginservice.LoginService;
import com.flab.marketflea.service.loginservice.sellerservice.SellerService;
import com.flab.marketflea.service.userservice.command.UserLoginCommand;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sellers")
public class SellerController {

    private final SellerService sellerService;
    private final LoginService loginService;
    private final SessionService sessionService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void signUpSeller(@RequestBody Seller seller) {
        sellerService.signUp(seller);
    }

    @GetMapping("/{shopName}/duplicate")
    public ResponseEntity<Void> isShopNameExist(@PathVariable("shopName") String shopName) {
        boolean isIdDuplicated = sellerService.isShopNameExist(shopName);
        if (isIdDuplicated) {
            return CONFLICT;
        }
        return OK;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/login")
    public void login(@RequestBody SellerLoginRequest sellerLoginRequest) {
        loginService.authenticate(new UserLoginCommand(sellerLoginRequest.getUserId(), sellerLoginRequest.getPassword(), sellerLoginRequest.getRole()));
    }

    @PostMapping("/logout")
    public void logout() {
        loginService.logout();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") long id,
        @RequestBody @Valid SellerRequest seller) {
        boolean isLoginUser = sessionService.isLoginUser();
        if (!isLoginUser) {
            return UNAUTHORIZED;
        }
        sellerService.update(id, seller);
        return OK;
    }

    @PatchMapping("/password")
    public ResponseEntity<Void> updatePassword(
        @RequestBody @Valid UpdatePasswordSeller updatePasswordSeller) {
        boolean isLoginUser = sessionService.isLoginUser();
        if (!isLoginUser) {
            return UNAUTHORIZED;
        }
        sellerService.updatePassword(updatePasswordSeller);
        return OK;
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteSeller(@RequestBody SellerLoginRequest sellerLoginRequest) {
        boolean isLoginUser = sessionService.isLoginUser();
        if (!isLoginUser) {
            return UNAUTHORIZED;
        }
        sellerService.deleteSeller(sellerLoginRequest);
        return OK;
    }
}
