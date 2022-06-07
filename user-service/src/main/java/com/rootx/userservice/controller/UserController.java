package com.rootx.userservice.controller;

import com.google.gson.JsonArray;
import com.rootx.userservice.entity.User;
import com.rootx.userservice.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody User user) {

        return ResponseEntity.ok().contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .body(userService.saveUser(user));
    }

    @GetMapping("/")
    public ResponseEntity<JsonArray> getUsers() {

        return ResponseEntity.ok().contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .body(userService.getUsers());
    }
}
