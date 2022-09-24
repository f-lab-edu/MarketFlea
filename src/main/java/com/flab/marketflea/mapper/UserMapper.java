package com.flab.marketflea.mapper;

import com.flab.marketflea.dto.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public void signUpMember(User user);

    public boolean isIdExist(String id);

}
