package com.flab.marketflea.mapper;

import com.flab.marketflea.model.UpdatePasswordUser;
import com.flab.marketflea.model.UpdateUserInfo;
import com.flab.marketflea.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void signUpUser(User user);

    boolean isIdExist(String userId);

    User getUserById(String userId);

    void updateUser(UpdateUserInfo updateUserInfo);

    void updateName(UpdateUserInfo updateUserInfo);

    void updateAddress(UpdateUserInfo updateUserInfo);

    void updatePhone(UpdateUserInfo updateUserInfo);

    void updatePassword(UpdatePasswordUser updatePasswordUser);
}
