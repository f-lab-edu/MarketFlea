package com.flab.marketflea.controller;

import com.flab.marketflea.common.SessionService;
import com.flab.marketflea.model.user.LoginUser;
import com.flab.marketflea.model.user.UpdatePasswordUser;
import com.flab.marketflea.model.user.UpdateUser;
import com.flab.marketflea.model.user.User;
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

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping
    public void update(@RequestBody @Valid UpdateUser updateUser) {
        userService.update(updateUser);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/password")
    public void updatePassword(@RequestBody @Valid UpdatePasswordUser updatePasswordUser) {
        userService.updatePassword(updatePasswordUser);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@RequestBody LoginUser loginUser) {

        boolean isLoginUser = sessionService.isLoginUser();
        if(!isLoginUser) {
            return UNAUTHORIZED;
        }
        userService.deleteUser(loginUser);

        return OK;
    }


}