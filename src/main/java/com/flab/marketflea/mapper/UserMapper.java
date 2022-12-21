package com.flab.marketflea.mapper;

import com.flab.marketflea.mapper.param.UserPasswordUpdateParam;
import com.flab.marketflea.model.user.LoginUser;
import com.flab.marketflea.model.user.UpdateUserInfo;
import com.flab.marketflea.model.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    void signUpUser(User user);

    boolean isIdExist(String userId);

    User getUserById(String userId);

    void updateUser(UpdateUserInfo updateUserInfo);

    User findByIdAndPassword(@Param("userId") String userId, @Param("password") String password);

    void updatePassword(UserPasswordUpdateParam param);

    void deleteUser(LoginUser loginUser);
}
