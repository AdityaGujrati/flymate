package com.example.flymate.controller;

import com.example.flymate.model.UserRequest;
import com.example.flymate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/v1/add-user")
    public void addUser(@RequestBody UserRequest userRequest){
        userService.addUser(userRequest);
    }

}
