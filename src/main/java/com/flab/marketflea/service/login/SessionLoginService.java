package com.flab.marketflea.service.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SessionLoginService implements LoginService {

    public static final String LOGIN_MEMBER = "loginMember";
    private final HttpSession session;

    @Override
    public void login(String id) {
        session.setAttribute(LOGIN_MEMBER, id);
        System.out.println("로그인 성공");
    }

    @Override
    public void logout() {
        session.invalidate();
    }
}
