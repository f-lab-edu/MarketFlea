package com.flab.marketflea.controller;

import com.flab.marketflea.domain.LoginUser;
import com.flab.marketflea.domain.UpdatePasswordUser;
import com.flab.marketflea.domain.UpdateUser;
import com.flab.marketflea.domain.User;
import com.flab.marketflea.service.loginservice.LoginService;
import com.flab.marketflea.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.flab.marketflea.common.ResponseEntityConstants.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<Void> signUp(@RequestBody User user) {
        userService.signUp(user);
        return CREATED;
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

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginUser loginUser) {

        User user = userService.getLoginUser(loginUser);

        if(user == null){
            return UNAUTHORIZED;
        }
        loginService.login(loginUser.getUserId(), loginUser.getPassword());
        return OK;
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        loginService.logout();
        return OK;
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody UpdateUser updateUser) {
        userService.update(updateUser);
        return OK;
    }

    @PutMapping("/update/password")
    public ResponseEntity<Void> updatePassword(UpdatePasswordUser updatePasswordUser) {
        userService.updatePassword(updatePasswordUser);
        return OK;
    }

}