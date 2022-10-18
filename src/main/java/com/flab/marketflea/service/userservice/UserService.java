package com.flab.marketflea.service.userservice;

import com.flab.marketflea.domain.*;
import com.flab.marketflea.exception.InValidValueException;
import com.flab.marketflea.mapper.UserMapper;
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

    public User getLoginUser(LoginUser loginUser) {
        String storedPassword = userMapper.getPassword(loginUser.getUserId());

        boolean isValidPassword = passwordEncoder.matches(loginUser.getPassword(), storedPassword);

        if (storedPassword == null || !isValidPassword) {
            return null;
        }
        User user = userMapper.getUserById(loginUser.getUserId());
        return user;

    }


    @Transactional(rollbackFor = RuntimeException.class)
    public void update(UpdateUser updateUser) {

        ChangedUser changedUser = ChangedUser.builder()
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

        String currentUserId = updatePasswordUser.getUserId();
        String currentUserPassword = updatePasswordUser.getNewPassword();

        boolean isValidPassword = passwordEncoder.matches(updatePasswordUser.getExistPassword(), currentUserPassword);

        if (!isValidPassword ||
                updatePasswordUser.getExistPassword().equals(updatePasswordUser.getNewPassword()) ||
                !updatePasswordUser.getNewPassword().equals(updatePasswordUser.getCheckNewPassword())) {
            throw new InValidValueException("올바르지 않은 값입니다. 다시 입력해주세요.");
        }

        String encryptedPassword = passwordEncoder.encrypt(updatePasswordUser.getNewPassword());
        LoginUser loginUser = new LoginUser(currentUserId, encryptedPassword);

        userMapper.updatePassword(LoginUser.builder().build());
    }


}


