package com.flab.marketflea.service.loginservice;

import com.flab.marketflea.model.request.LoginRequest;

public interface LoginService {

    void authenticate(LoginRequest loginRequest);

    void deauthenticate();

    boolean isValidAuthentication();

    String getAuthenticatedUserId();

    void logout();
}
