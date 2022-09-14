package com.flab.marketflea.mapper;

import com.flab.marketflea.dto.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> getAll();

    public User get(String id);

    public boolean add(User user);

    public boolean isIdExist(String id);
}
