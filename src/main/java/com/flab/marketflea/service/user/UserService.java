package com.flab.marketflea.service.user;

import com.flab.marketflea.common.SessionUtils;
import com.flab.marketflea.domain.User;
import com.flab.marketflea.exception.DuplicatedUserException;
import com.flab.marketflea.mapper.UserMapper;
import com.flab.marketflea.security.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final SessionUtils sessionUtils;
    private final PasswordEncoder passwordEncoder;

    public void signUp(User user) {
        user.setPassword(passwordEncoder.encrypt(user.getPassword()));
        userMapper.signUpMember(user);
    }

    public void isIdExist(final User user) {

        if (userMapper.isIdExist(user.getId())) {
            throw new DuplicatedUserException("이미 존재하는 이메일입니다.");
        }
    }
}
