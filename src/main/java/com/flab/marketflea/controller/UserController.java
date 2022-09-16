package com.flab.marketflea.controller;

import com.flab.marketflea.dto.user.User;
import com.flab.marketflea.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    // 회원가입 완료 버튼 클릭
    @PostMapping("")
    public void save( @Valid @RequestBody User user) {
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
}

