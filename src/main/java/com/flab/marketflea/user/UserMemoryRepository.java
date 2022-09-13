package com.flab.marketflea.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserMemoryRepository implements UserRepository {
    private final List<User> list = new ArrayList<>();

    @Override
    public List<User> getList() {
        return list;
    }

    @Override
    public void save(User user) {
        list.add(user);
    }

    @Override
    public User get(String id) {
        for(User user : list){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }
}
