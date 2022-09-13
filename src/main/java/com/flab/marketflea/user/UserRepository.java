package com.flab.marketflea.user;

import java.util.List;

public interface UserRepository {
    public List<User> getList();
    public void save(User user);
    public User get(String id);
}
