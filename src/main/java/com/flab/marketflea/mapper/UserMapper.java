package com.flab.marketflea.mapper;

import com.flab.marketflea.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public void signUpMember(User user);

    public boolean isIdExist(String id);

    public User getUserById(String id);

}
