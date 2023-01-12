package com.flab.marketflea.controller;

import static com.flab.marketflea.common.ResponseEntityConstants.CONFLICT;
import static com.flab.marketflea.common.ResponseEntityConstants.OK;
import static com.flab.marketflea.common.ResponseEntityConstants.UNAUTHORIZED;

import com.flab.marketflea.common.SessionService;
import com.flab.marketflea.model.user.CustomerLoginRequest;
import com.flab.marketflea.model.user.LoginUser;
import com.flab.marketflea.model.user.UpdateUser;
import com.flab.marketflea.model.user.User;
import com.flab.marketflea.service.userservice.command.UserPasswordUpdateCommand;
import com.flab.marketflea.model.user.UserPasswordUpdateRequest;
import com.flab.marketflea.service.loginservice.LoginService;
import com.flab.marketflea.service.userservice.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


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
        }
        return OK;
    }


    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/login")
    public void login(@RequestBody @Valid CustomerLoginRequest customerLoginRequest) {
        loginService.authenticate(customerLoginRequest);
    }

    @PostMapping("/logout")
    public void logout() {
        loginService.logout();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateUser updateUser) {
        boolean isLoginUser = sessionService.isLoginUser();
        if (!isLoginUser) {
            return UNAUTHORIZED;
        }
        userService.update(updateUser);

        return OK;
    }

    @PatchMapping("/password")
    public ResponseEntity<Void> updatePassword(@RequestBody @Valid UserPasswordUpdateRequest request) {
        boolean isLoginUser = sessionService.isLoginUser();
        if (!isLoginUser) {
            return UNAUTHORIZED;
        }
        userService.updatePassword(
            UserPasswordUpdateCommand
                .builder()
                .userId(request.getUserId())
                .password(request.getPassword())
                .build()
        );
        return OK;
    }


    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestBody LoginUser loginUser) {

        boolean isLoginUser = sessionService.isLoginUser();
        if (!isLoginUser) {
            return UNAUTHORIZED;
        }
        userService.deleteUser(loginUser);
        return OK;
    }


}