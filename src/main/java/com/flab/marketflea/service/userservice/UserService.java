package com.flab.marketflea.service.userservice;

import com.flab.marketflea.common.ErrorCode;
import com.flab.marketflea.exception.user.DuplicatedUserException;
import com.flab.marketflea.exception.user.UserNotFoundException;
import com.flab.marketflea.exception.user.WrongPasswordException;
import com.flab.marketflea.mapper.UserMapper;
import com.flab.marketflea.mapper.param.UserInfoParam;
import com.flab.marketflea.mapper.param.UserLoginParam;
import com.flab.marketflea.mapper.param.UserPasswordUpdateParam;
import com.flab.marketflea.mapper.param.UserUpdateParam;
import com.flab.marketflea.model.user.UserInfoRequest;
import com.flab.marketflea.security.PasswordEncoder;
import com.flab.marketflea.service.userservice.command.UserInfoCommand;
import com.flab.marketflea.service.userservice.command.UserLoginCommand;
import com.flab.marketflea.service.userservice.command.UserPasswordUpdateCommand;
import com.flab.marketflea.service.userservice.command.UserUpdateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(UserInfoCommand command) {
        UserInfoParam param = UserInfoParam.builder()
            .userId(command.getUserId())
            .name(command.getName())
            .role(command.getRole())
            .phone(command.getPhone())
            .email(command.getEmail())
            .address(command.getAddress())
            .password(passwordEncoder.encrypt(command.getPassword()))
            .build();
        if(isIdExist(command.getUserId()))
            throw new DuplicatedUserException("DuplicatedUserException", ErrorCode.USER_DUPLICATION);
        userMapper.signUpUser(param);
    }

    public boolean isIdExist(String userId) {
        return userMapper.isIdExist(userId);
    }

    public UserInfoRequest getUserById(UserLoginCommand command) {
        if (!isIdExist(command.getUserId())) {
            throw new UserNotFoundException("UserNotFoundException", ErrorCode.USER_NOT_FOUND);
        }
        return userMapper.getUserById(command.getUserId());
    }

    @Transactional
    public void update(UserUpdateCommand command) {
        UserUpdateParam param = UserUpdateParam
            .builder()
            .userId(command.getUserId())
            .name(command.getName())
            .phone(command.getPhone())
            .email(command.getEmail())
            .address(command.getAddress())
            .updatedAt(command.getUpdatedAt())
            .build();
        userMapper.updateUser(param);
    }

    @Transactional
    public void updatePassword(UserPasswordUpdateCommand command) {
        UserPasswordUpdateParam param = UserPasswordUpdateParam
            .builder()
            .userId(command.getUserId())
            .password(passwordEncoder.encrypt(command.getPassword()))
            .build();
        userMapper.updatePassword(param);

    }

    @Transactional
    public void deleteUser(UserLoginCommand command) {
        UserLoginParam param = UserLoginParam
            .builder()
            .userId(command.getUserId())
            .password(passwordEncoder.encrypt(command.getPassword()))
            .build();

        boolean isValidPassword = passwordEncoder.matches(command.getPassword(),
            userMapper.getUserById(command.getUserId()).getPassword());
        if (!isValidPassword) {
            throw new WrongPasswordException("WrongPasswordException", ErrorCode.WRONG_PASSWORD);
        }
        userMapper.deleteUser(param);

    }
}


