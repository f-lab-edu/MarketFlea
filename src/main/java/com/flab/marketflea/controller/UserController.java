package com.flab.marketflea.controller;

import com.flab.marketflea.dto.user.LoginUser;
import com.flab.marketflea.dto.user.User;
import com.flab.marketflea.service.login.LoginService;
import com.flab.marketflea.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final LoginService loginService;

    // 회원가입 완료 버튼 클릭
    @PostMapping("")
    public void save(@RequestBody User user) {
        userService.signUp(user);
    }

    // 회원가입 페이지에서 id 중복체그
    @GetMapping("/{id}/exist")
    public ResponseEntity<Void> isIdExist(@PathVariable String id) {
        if (userService.isIdExist(id)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginUser loginUser) {
        String id = loginUser.getId();
        String password = loginUser.getPassword();

        Optional<User> user = userService.getUserByIdAndPassword(id, password);

        if (!user.isPresent()) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        } else {
            loginService.login(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

}

