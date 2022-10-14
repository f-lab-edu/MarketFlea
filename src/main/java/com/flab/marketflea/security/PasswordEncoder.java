package com.flab.marketflea.security;

public interface PasswordEncoder {

    public String encrypt(String password);

    public boolean matches(String password, String encodedPassword);
}