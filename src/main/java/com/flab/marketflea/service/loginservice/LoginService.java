package com.flab.marketflea.service.loginservice;

public interface LoginService {
    String login(String userId, String password);

    void logout();
}
