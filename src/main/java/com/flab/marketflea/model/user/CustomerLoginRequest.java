package com.flab.marketflea.model.user;

import com.flab.marketflea.model.request.LoginRequest;

public class CustomerLoginRequest extends LoginRequest {

    @Override
    public Role getRole() {
        return Role.CUSTOMER;
    }

}
