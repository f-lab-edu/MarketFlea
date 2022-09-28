package com.flab.marketflea.service.login;

import com.flab.marketflea.dto.user.LoginUser;
import org.springframework.http.ResponseEntity;
import javax.servlet.http.HttpServletRequest;


public interface LoginService {
    public static final String LOGIN_USER = "loginUser";

    public ResponseEntity<Void> login(LoginUser loginUser);

    public void logout();
}
