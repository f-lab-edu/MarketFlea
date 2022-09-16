package com.flab.marketflea.service.user;

import com.flab.marketflea.dto.user.User;
import com.flab.marketflea.exception.IdExistException;
import com.flab.marketflea.mapper.UserMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper mapper;

    public void signUp(User user) {
        if(isIdExist(user.getId())){
            throw new IdExistException();
        }

        mapper.add(user);
    }

    public boolean isIdExist(String id) {
        return mapper.isIdExist(id);
    }

    public User encrypt(User user) {

        user.setPassword(user.getPassword());
        return null;


    }
}


