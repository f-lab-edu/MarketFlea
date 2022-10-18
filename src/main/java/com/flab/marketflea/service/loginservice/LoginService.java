package com.flab.marketflea.service.loginservice;

public interface LoginService {
    public String login(String userId, String password);

    public void logout();
}
