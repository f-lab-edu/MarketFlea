package com.flab.marketflea.user;

import java.util.List;

public interface UserService {
    public void join(User user);
    public List<User> getAll();
    public User get(String id);
}
