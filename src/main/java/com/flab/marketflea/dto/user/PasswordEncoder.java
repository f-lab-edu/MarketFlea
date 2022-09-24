package com.flab.marketflea.dto.user;

public interface PasswordEncoder {

    public String encrypt(String password);

    public boolean isMatch(String password, String hashedPassword);
}