package com.flab.marketflea.controller;

import com.flab.marketflea.domain.LoginUser;
import com.flab.marketflea.domain.User;
import com.flab.marketflea.service.user.LoginService;
import com.flab.marketflea.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;
    private final LoginService loginService;

    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid User user) {
        userService.isIdExist(user);
        userService.signUp(user);
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