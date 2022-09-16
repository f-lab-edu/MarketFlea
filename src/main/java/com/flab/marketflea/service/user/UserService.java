package com.flab.marketflea.service.user;

import com.flab.marketflea.dto.user.User;
import com.flab.marketflea.exception.IdExistException;
import com.flab.marketflea.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper mapper;


    public void signUp(User user) {

        if (isIdExist(user.getId())) {
            throw new IdExistException();
        }

        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
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


