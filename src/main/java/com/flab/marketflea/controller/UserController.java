package com.flab.marketflea.controller;

import com.flab.marketflea.dto.user.User;
import com.flab.marketflea.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public List<User> getUser() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) {
        return userService.get(id);
    }

    @PostMapping("")
    public User save(@RequestBody User user) {
        userService.signUp(user);
        return user;
    }
}
