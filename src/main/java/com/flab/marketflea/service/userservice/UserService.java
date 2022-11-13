package com.flab.marketflea.service.userservice;

import com.flab.marketflea.exception.InValidValueException;
import com.flab.marketflea.mapper.UserMapper;
import com.flab.marketflea.model.user.*;
import com.flab.marketflea.security.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public void signUp(User user) {
        User encryptedUser = User.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .role(user.getRole())
                .phone(user.getPhone())
                .email(user.getEmail())
                .address(user.getAddress())
                .password(passwordEncoder.encrypt(user.getPassword()))
                .build();

        userMapper.signUpUser(encryptedUser);
    }

    public boolean isIdExist(String userId) {
        return userMapper.isIdExist(userId);
    }


    @Transactional
    public void update(UpdateUser updateUser) {

        UpdateUserInfo changedUser = UpdateUserInfo.builder()
                .userId(updateUser.getUserId())
                .name(updateUser.getName())
                .phone(updateUser.getPhone())
                .email(updateUser.getEmail())
                .address(updateUser.getAddress())
                .updatedAt(updateUser.getUpdatedAt())
                .build();

        userMapper.updateUser(changedUser);

    }


    @Transactional
    public void updatePassword(UpdatePasswordUser updatePasswordUser)
            throws InValidValueException {

        UpdatePasswordUser encodeUser = UpdatePasswordUser.builder()
                .userId(updatePasswordUser.getUserId())
                .password(passwordEncoder.encrypt(updatePasswordUser.getPassword()))
                .build();

        userMapper.updatePassword(encodeUser);

    }

    public void deleteUser(LoginUser loginUser) throws InValidValueException {

        LoginUser encodeUser = LoginUser.builder()
                .userId(loginUser.getUserId())
                .password(passwordEncoder.encrypt(loginUser.getPassword()))
                .build();

        boolean isValidPassword = passwordEncoder.matches(loginUser.getPassword(),userMapper.getUserById(loginUser.getUserId()).getPassword());

        if (!isValidPassword) {
            throw new InValidValueException("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
        }

        userMapper.deleteUser(encodeUser);


    }
}


