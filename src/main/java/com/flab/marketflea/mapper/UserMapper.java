package com.flab.marketflea.mapper;

import com.flab.marketflea.mapper.param.UserInfoParam;
import com.flab.marketflea.mapper.param.UserLoginParam;
import com.flab.marketflea.mapper.param.UserPasswordUpdateParam;
import com.flab.marketflea.mapper.param.UserUpdateParam;
import com.flab.marketflea.model.user.UserInfoRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void signUpUser(UserInfoParam param);

    boolean isIdExist(String userId);

    UserInfoRequest getUserById(String userId);

    void updateUser(UserUpdateParam param);

    void updatePassword(UserPasswordUpdateParam param);

    void deleteUser(UserLoginParam param);
}
