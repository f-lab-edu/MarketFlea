package com.flab.marketflea.controller;

import com.flab.marketflea.dto.user.LoginUser;
import com.flab.marketflea.dto.user.User;
import com.flab.marketflea.service.login.LoginService;
import com.flab.marketflea.service.login.SessionLoginService;
import com.flab.marketflea.service.user.UserService;
import com.flab.marketflea.utility.HttpStatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final LoginService loginService;

    @PostMapping("")
    public void save(@RequestBody User user) {
        userService.signUp(user);
    }

    @GetMapping("/{id}/exist")
    public ResponseEntity<Void> isIdExist(@PathVariable String id) {
        if (userService.isIdExist(id)) {
            return HttpStatusCode.CONFLICT;
        }

        return HttpStatusCode.OK;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginUser loginUser, HttpServletRequest request) {
        return loginService.login(loginUser, request);
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request) {
        loginService.logout(request);
    }

}

