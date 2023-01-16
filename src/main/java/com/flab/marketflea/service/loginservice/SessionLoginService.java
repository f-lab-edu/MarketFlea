package com.flab.marketflea.service.loginservice;


import com.flab.marketflea.common.SessionService;
import com.flab.marketflea.model.user.Role;
import com.flab.marketflea.service.loginservice.sellerservice.SellerService;
import com.flab.marketflea.service.userservice.UserService;
import com.flab.marketflea.service.userservice.command.UserLoginCommand;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class SessionLoginService implements LoginService {

    private static final String LOGIN_MEMBER_ID = "LOGIN_MEMBER_ID";
    private final HttpSession httpSession;
    private final SessionService sessionService;
    private final SellerService sellerService;
    private final UserService userService;

    @Override
    public void authenticate(UserLoginCommand command) {
        String userId = command.getUserId();
        String password = command.getPassword();
        Role role = command.getRole();
        if (isSeller(role)) {
            sellerService.getByIdAndPw(userId, password);
        } else {
            userService.getUserById(command);
        }
        httpSession.setAttribute("LOGIN_MEMBER_ID", userId);
        httpSession.setAttribute("ROLE_KEY", role);
    }

    @Override
    public void deauthenticate() {
        httpSession.invalidate();
    }

    @Override
    public boolean isValidAuthentication() {
        return httpSession.getAttribute(LOGIN_MEMBER_ID) != null;
    }

    @Override
    public String getAuthenticatedUserId() {
        return (String) httpSession.getAttribute(LOGIN_MEMBER_ID);
    }

    private boolean isSeller(Role role) {
        return role.equals(Role.SELLER);
    }

    @Override
    public void logout() {
        sessionService.deleteLoginMemberId();
    }
}




