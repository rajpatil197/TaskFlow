package com.taskflow.controller;


import com.taskflow.dto.UserCreateRequest;
import com.taskflow.dto.UserResponse;
import com.taskflow.entity.User;
import com.taskflow.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public UserResponse createUser(@RequestBody UserCreateRequest userRequest){
        return userService.createUser(userRequest);
    }

}
