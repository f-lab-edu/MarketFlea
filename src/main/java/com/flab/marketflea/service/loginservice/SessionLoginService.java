package com.flab.marketflea.service.loginservice;


import com.flab.marketflea.common.SessionService;
import com.flab.marketflea.model.User;
import com.flab.marketflea.exception.LoginFailedException;
import com.flab.marketflea.mapper.UserMapper;
import com.flab.marketflea.security.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class SessionLoginService implements LoginService {

    private final SessionService sessionService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String login(String userId, String password) {

        User matchMember = userMapper.getUserById(userId);
        if (matchMember == null || !passwordEncoder.matches(password, matchMember.getPassword())) {
            throw new LoginFailedException("사용자가 존재하지 않거나 비밀번호가 틀렸습니다.");
        }
        sessionService.setLoginMemberId(matchMember.getUserId());
        return null;
    }

    @Override
    public void logout() {
        sessionService.deleteLoginMemberId();
    }

}