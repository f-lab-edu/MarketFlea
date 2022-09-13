package com.flab.marketflea.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserRepository repository;

    @Override
    public void join(User user) {
        repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return repository.getList();
    }

    @Override
    public User get(String id) {
        return repository.get(id);
    }
}
