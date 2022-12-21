package com.flab.marketflea.model.seller;

import com.flab.marketflea.model.request.LoginRequest;
import com.flab.marketflea.model.user.Role;

public class SellerLoginRequest extends LoginRequest {

    @Override
    public Role getRole() {
        return Role.SELLER;
    }
}
