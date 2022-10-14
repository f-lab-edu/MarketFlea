package com.flab.marketflea.controller;

import com.flab.marketflea.domain.LoginUser;
import com.flab.marketflea.domain.User;
import com.flab.marketflea.service.user.LoginService;
import com.flab.marketflea.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final LoginService loginService;

    @PostMapping("")
    public void signUp(@RequestBody User user) {
        userService.signUp(user);
    }

    @GetMapping("/{id}/duplicate")
    public HttpStatus isIdDuplicated(@PathVariable String id) {
        boolean isIdDuplicated = userService.isIdExist(id);
        if (isIdDuplicated) {
            return CONFLICT;
        } else {
            return OK;
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginUser loginUser) {
        return loginService.login(loginUser.getId(), loginUser.getPassword());
    }

    @PostMapping("/logout")
    public void logout() {
        loginService.logout();
    }

}