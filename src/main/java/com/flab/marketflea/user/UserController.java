package com.flab.marketflea.user;

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
        userService.join(user);
        return user;
    }
}
