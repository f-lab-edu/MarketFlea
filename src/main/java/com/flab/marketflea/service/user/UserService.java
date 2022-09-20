package com.flab.marketflea.service.user;

import com.flab.marketflea.error.exception.DbException;
import com.flab.marketflea.mapper.UserMapper;
import com.flab.marketflea.dto.user.User;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper mapper;

    public void insertMember(User user) throws DbException {

        /*
         * isIdExist를 통해 아이디 중복체크를 하기 때문에 아래 if문은 생략 가능하다.
         *
        if (isIdExist(user.getId())) {
            throw new IdExistException();
        }*/

        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        mapper.insertMember(user);
    }

    public boolean isIdExist(String id) {

        return mapper.isIdExist(id);
    }

    public User encrypt(User user) {

        user.setPassword(user.getPassword());
        return null;

    }
}