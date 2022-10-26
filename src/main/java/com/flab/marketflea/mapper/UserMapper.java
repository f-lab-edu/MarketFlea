package com.flab.marketflea.mapper;

import com.flab.marketflea.model.user.ChangedUser;
import com.flab.marketflea.model.user.LoginUser;
import com.flab.marketflea.model.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void signUpUser(User user);

    boolean isIdExist(String userId);

    User getUserById(String userId);

    void updateUser(ChangedUser changedUser);

    void updatePassword(LoginUser loginUser);

    void deleteUser(LoginUser loginUser);
}
