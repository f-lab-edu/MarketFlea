package com.flab.marketflea.controller;

import com.flab.marketflea.dto.user.User;
import com.flab.marketflea.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.flab.marketflea.common.ResponseEntityConstants.RESPONSE_ENTITY_CONFLICT;
import static com.flab.marketflea.common.ResponseEntityConstants.RESPONSE_ENTITY_OK;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public void signUp( @Valid @RequestBody User user) {
        userService.signUp(user);
    }


    @GetMapping("/{id}/duplicate")
    public ResponseEntity<HttpStatus> isIdDuplicated(@PathVariable @Valid String id) {
        boolean isIdDuplicated = userService.isIdExist(id);
        if (isIdDuplicated) {
            return RESPONSE_ENTITY_CONFLICT;
        } else {
            return RESPONSE_ENTITY_OK;
        }
    }
}