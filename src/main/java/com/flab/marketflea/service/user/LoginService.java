package com.flab.marketflea.service.user;

public interface LoginService {
    public String login(String id, String password);

    public void logout();
}
