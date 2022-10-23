package com.flab.marketflea.mapper;

import com.flab.marketflea.model.ChangedUser;
import com.flab.marketflea.model.LoginUser;
import com.flab.marketflea.model.User;
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
