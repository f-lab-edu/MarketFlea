package com.flab.marketflea.mapper;

import com.flab.marketflea.domain.ChangedUser;
import com.flab.marketflea.domain.LoginUser;
import com.flab.marketflea.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void signUpUser(User user);

    boolean isIdExist(String userId);

    User getUserById(String userId);

    String getPassword(String userId);

    void updateUser(ChangedUser changedUser);

    void updatePassword(LoginUser loginUser);
}
