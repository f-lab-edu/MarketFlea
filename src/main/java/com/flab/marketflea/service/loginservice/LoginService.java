package com.flab.marketflea.service.loginservice;

import com.flab.marketflea.service.userservice.command.UserLoginCommand;

public interface LoginService {

    void authenticate(UserLoginCommand command);

    void deauthenticate();

    boolean isValidAuthentication();

    String getAuthenticatedUserId();

    void logout();
}
