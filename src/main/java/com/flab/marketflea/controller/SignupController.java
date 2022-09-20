package com.flab.marketflea.controller;

import com.flab.marketflea.error.exception.DbException;
import com.flab.marketflea.dto.user.User;
import com.flab.marketflea.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class SignupController {


    private final UserService userService;

    @PostMapping("")
    public void save(@Valid @RequestBody User user) throws DbException {
        userService.insertMember(user);
    }


    @GetMapping("/{id}/exist")
    public ResponseEntity<Void> isIdExist(@PathVariable String id) {
        if (userService.isIdExist(id)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);


        }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
