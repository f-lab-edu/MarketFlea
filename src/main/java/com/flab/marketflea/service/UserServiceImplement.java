package com.flab.marketflea.service;

import com.flab.marketflea.dto.user.User;
import com.flab.marketflea.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserMapper mapper;

    @Override
    public void join(User user) {
        mapper.add(user);
    }

    @Override
    public List<User> getAll() {
        return mapper.getAll();
    }

    @Override
    public User get(String id) {
        return mapper.get(id);
    }
}
