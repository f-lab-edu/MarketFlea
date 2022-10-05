package com.flab.marketflea.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Slf4j
@Component
@RequiredArgsConstructor
public class SessionService {

    private static final String LOGIN_MEMBER_ID = "LOGIN_MEMBER_ID";
    private final HttpSession httpSession;


    public String getLoginMemberId() {
        return (String) httpSession.getAttribute(LOGIN_MEMBER_ID);
    }

    public void setLoginMemberId(String id) {
        httpSession.setAttribute(LOGIN_MEMBER_ID, id);
        log.info("세션 LOGIN_MEMBER_ID 적용: {}", id);
    }

    public void deleteLoginMemberId() {
        httpSession.removeAttribute(LOGIN_MEMBER_ID);
        log.info("세션 LOGIN_MEMBER_ID 삭제 후 세션아이디 null 정상반영 여부:{}", (getLoginMemberId() == null));
    }
}