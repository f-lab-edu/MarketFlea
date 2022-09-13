package com.flab.marketflea.service;

import com.flab.marketflea.dto.user.User;

import java.util.List;

public interface UserService {
    public void join(User user);
    public List<User> getAll();
    public User get(String id);
}
