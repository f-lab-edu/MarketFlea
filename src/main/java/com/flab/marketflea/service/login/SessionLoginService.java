package com.flab.marketflea.service.login;

import com.flab.marketflea.dto.user.LoginUser;
import com.flab.marketflea.dto.user.User;
import com.flab.marketflea.service.user.UserService;
import com.flab.marketflea.utility.HttpStatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SessionLoginService implements LoginService {

    private final UserService userService;

    @Override
    public ResponseEntity<Void> login(LoginUser loginUser, HttpServletRequest request) {
        Optional<User> user = userService.getUserByIdAndPassword(loginUser.getId(), loginUser.getPassword());

        if (!user.isPresent()) return HttpStatusCode.BAD_REQUEST;

        HttpSession session = request.getSession();
        session.setAttribute(LOGIN_USER, loginUser.getId());
        session.setMaxInactiveInterval(30 * 60);

        return HttpStatusCode.OK;
    }

    @Override
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        session.invalidate();
    }

}
