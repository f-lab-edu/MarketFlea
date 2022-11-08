package com.flab.marketflea.controller;

import com.flab.marketflea.common.SessionService;
import com.flab.marketflea.model.LoginUser;
import com.flab.marketflea.model.UpdatePasswordUser;
import com.flab.marketflea.model.UpdateUser;
import com.flab.marketflea.model.User;
import com.flab.marketflea.service.loginservice.LoginService;
import com.flab.marketflea.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.flab.marketflea.common.ResponseEntityConstants.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    private final LoginService loginService;
    private final SessionService sessionService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public void signUp(@RequestBody User user) {
        userService.signUp(user);
    }

    @GetMapping("/{id}/duplicate")
    public ResponseEntity<Void> isIdDuplicated(@PathVariable String id) {
        boolean isIdDuplicated = userService.isIdExist(id);
        if (isIdDuplicated) {
            return CONFLICT;
        } else {
            return OK;
        }
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/login")
    public void login(@RequestBody LoginUser loginUser) {
        loginService.login(loginUser.getUserId(), loginUser.getPassword());
    }

    @PostMapping("/logout")
    public void logout() {
        loginService.logout();
    }


    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateUser updateUser) {
        boolean isLoginUser = sessionService.isLoginUser();
        if (isLoginUser != true) {
            return UNAUTHORIZED;
        }
        userService.update(updateUser);

        return OK;
    }



    @PatchMapping("/password")
    public ResponseEntity<Void> updatePassword(@RequestBody @Valid UpdatePasswordUser updatePasswordUser) {
        boolean isLoginUser = sessionService.isLoginUser();
        if (isLoginUser != true) {
            return UNAUTHORIZED;
        }
        userService.updatePassword(updatePasswordUser);
        return OK;
    }


}