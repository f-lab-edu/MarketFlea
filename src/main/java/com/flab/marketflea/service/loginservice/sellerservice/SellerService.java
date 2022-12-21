package com.flab.marketflea.service.loginservice.sellerservice;

import com.flab.marketflea.common.ErrorCode;
import com.flab.marketflea.exception.shop.DuplicatedShopException;
import com.flab.marketflea.exception.user.DuplicatedUserException;
import com.flab.marketflea.exception.user.UserNotFoundException;
import com.flab.marketflea.exception.user.WrongPasswordException;
import com.flab.marketflea.mapper.SellerMapper;
import com.flab.marketflea.model.seller.SellerLoginRequest;
import com.flab.marketflea.model.seller.Seller;
import com.flab.marketflea.model.seller.SellerRequest;
import com.flab.marketflea.model.seller.UpdatePasswordSeller;
import com.flab.marketflea.security.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerMapper sellerMapper;
    private final PasswordEncoder passwordEncoder;

    public void signUp(Seller seller) {
        Seller encryptedUser = Seller.builder()
            .userId(seller.getUserId())
            .name(seller.getName())
            .role(seller.getRole())
            .shopName(seller.getShopName())
            .phone(seller.getPhone())
            .email(seller.getEmail())
            .address(seller.getAddress())
            .password(passwordEncoder.encrypt(seller.getPassword()))
            .build();

        if (isShopNameExist(seller.getShopName())) {
            throw new DuplicatedShopException("DuplicatedShopException",
                ErrorCode.SHOP_DUPLICATION);
        }
        if (isIdExist(seller.getUserId())) {
            throw new DuplicatedUserException("DuplicatedUserException",
                ErrorCode.USER_DUPLICATION);
        }
        sellerMapper.signUp(encryptedUser);
    }

    public boolean isShopNameExist(String shopName) {
        return sellerMapper.isShopNameExist(shopName);
    }

    public boolean isIdExist(String userId) {
        return sellerMapper.isIdExist(userId);
    }

    public Seller getByIdAndPw(String userId, String password) {
        Seller seller = sellerMapper.findByIdAndPassword(userId, passwordEncoder.encrypt(password));
        if (!isIdExist(userId)) {
            throw new UserNotFoundException("UserNotFoundException", ErrorCode.USER_NOT_FOUND);
        }
        return seller;
    }

    @Transactional
    public void update(long id, SellerRequest seller) {
        sellerMapper.update(seller.toEntity(id));
    }

    @Transactional
    public void updatePassword(UpdatePasswordSeller updatePasswordSeller) {
        Seller encodeUser = Seller.builder()
            .userId(updatePasswordSeller.getUserId())
            .password(passwordEncoder.encrypt(updatePasswordSeller.getPassword()))
            .build();
        sellerMapper.updatePassword(encodeUser);
    }

    @Transactional
    public void deleteSeller(SellerLoginRequest sellerLoginRequest) {
        Seller encodeUser = Seller.builder()
            .userId(sellerLoginRequest.getUserId())
            .password(passwordEncoder.encrypt(sellerLoginRequest.getPassword()))
            .build();

        boolean isValidPassword = passwordEncoder.matches(sellerLoginRequest.getPassword(),
            sellerMapper.getSellerById(sellerLoginRequest.getUserId()).getPassword());

        if (!isValidPassword) {
            throw new WrongPasswordException("WrongPasswordException", ErrorCode.WRONG_PASSWORD);
        }
        sellerMapper.deleteSeller(encodeUser);
    }
}

