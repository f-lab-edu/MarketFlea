package com.flab.marketflea.mapper;

import com.flab.marketflea.dto.user.User;
import com.flab.marketflea.exception.DbException;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public void add(User user) throws DbException;

    public boolean isIdExist(String id);
}
