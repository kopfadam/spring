package com.aga.boot.rest;

import com.aga.boot.model.User;
import com.aga.boot.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> addOwner(@RequestBody @Valid User user) throws Exception{

        if (user == null)
            return ResponseEntity.badRequest().build();

        userService.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
}
