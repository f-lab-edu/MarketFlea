package com.flab.marketflea.service.user;

import com.flab.marketflea.dto.user.User;

import java.util.List;

public interface UserService {


    public boolean signUp(User user);
    public List<User> getAll();
    public User get(String id);
    public boolean isIdExist(String id);
}


