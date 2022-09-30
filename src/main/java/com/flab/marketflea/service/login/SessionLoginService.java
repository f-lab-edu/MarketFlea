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

import static com.flab.marketflea.utility.HttpStatusCode.*;

@Service
@RequiredArgsConstructor
public class SessionLoginService implements LoginService {

    private final UserService userService;
    private final HttpSession httpSession;

    @Override
    public ResponseEntity<Void> login(LoginUser loginUser) {
        Optional<User> user = userService.getUserByIdAndPassword(loginUser.getId(), loginUser.getPassword());

        if (!user.isPresent()) return BAD_REQUEST;

        httpSession.setAttribute(LOGIN_USER, loginUser.getId());
        return OK;
    }

    @Override
    public void logout() {
        httpSession.removeAttribute(LOGIN_USER);
    }

}
