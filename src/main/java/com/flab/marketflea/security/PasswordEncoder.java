package com.flab.marketflea.security;

public interface PasswordEncoder {

    String encrypt(String password);

    boolean matches(String password, String encodedPassword);
}