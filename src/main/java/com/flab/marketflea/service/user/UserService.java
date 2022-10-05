package com.flab.marketflea.service.user;

import com.flab.marketflea.dto.user.User;
import com.flab.marketflea.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper mapper;

    public void signUp(User user) {

        User encryptedUser = User.builder()
                                 .id(user.getId())
                                 .name(user.getName())
                                 .role(user.getRole())
                                 .phone(user.getPhone())
                                 .email(user.getEmail())
                                 .address(user.getAddress())
                                 .password(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()))
                                 .build();

        mapper.add(encryptedUser);
    }

    public boolean isIdExist(String id) {
        return mapper.isIdExist(id);
    }

    public Optional<User> getUserByIdAndPassword(String id, String password) {

        if (!isIdExist(id)) return Optional.empty();

        Optional<User> user = Optional.ofNullable(mapper.getUserById(id));

        if (BCrypt.checkpw(password, user.get()
                                         .getPassword())) {
            return user;
        }
        else {
            return Optional.empty();
        }
    }
}




