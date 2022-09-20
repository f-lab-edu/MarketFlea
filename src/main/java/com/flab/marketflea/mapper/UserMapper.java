package com.flab.marketflea.mapper;

import com.flab.marketflea.error.exception.DbException;
import com.flab.marketflea.dto.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public void insertMember(User user) throws DbException;

    public boolean isIdExist(String id);

}
