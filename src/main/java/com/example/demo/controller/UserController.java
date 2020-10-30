package com.example.demo.controller;


import com.example.demo.dto.request.CreateUserRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserResponse getUser (@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping
    public List<UserResponse> getALlUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest request) throws Exception{
        return userService.createUser(request);
    }


}
