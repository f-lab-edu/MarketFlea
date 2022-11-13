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


    @Transactional(rollbackFor = Exception.class)
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
        if (isValidPassword) {
            throw new InValidValueException("이전 비밀번호와 같은 값입니다. 다시 입력해주세요.");
        }

        String encryptedPassword = passwordEncoder.encrypt(updatePasswordUser.getNewPassword());
        LoginUser loginUser = new LoginUser(currentUserId, encryptedPassword);

        userMapper.updatePassword(loginUser.builder().build());

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


