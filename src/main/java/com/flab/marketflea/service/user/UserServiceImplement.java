package com.flab.marketflea.service.user;

import com.flab.marketflea.dto.user.User;
import com.flab.marketflea.exception.IdExistException;
import com.flab.marketflea.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

    private final UserMapper mapper;

    @Override
    public final boolean signUp(User user) {
        if(isIdExist(user.getId())){
            throw new IdExistException();
        }
        user.setCreated_at(LocalDateTime.now());
        user.setUpdated_at(LocalDateTime.now());
        return mapper.add(user);
    }

    @Override
    public final List<User> getAll() {
        return mapper.getAll();
    }

    @Override
    public final User get(String id) {
        return mapper.get(id);
    }

    @Override
    public final boolean isIdExist(String id) {
        return mapper.isIdExist(id);
    }
}
