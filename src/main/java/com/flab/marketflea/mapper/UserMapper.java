package com.flab.marketflea.mapper;

import com.flab.marketflea.model.user.LoginUser;
import com.flab.marketflea.model.user.UpdatePasswordUser;
import com.flab.marketflea.model.user.UpdateUserInfo;
import com.flab.marketflea.model.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void signUpUser(User user);

    boolean isIdExist(String userId);

    User getUserById(String userId);

    void updateUser(UpdateUserInfo updateUserInfo);

    void updatePassword(UpdatePasswordUser updatePasswordUser);

    void deleteUser(LoginUser loginUser);
}
