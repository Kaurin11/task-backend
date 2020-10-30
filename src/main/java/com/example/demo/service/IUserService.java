package com.example.demo.service;

import com.example.demo.dto.request.CreateUserRequest;
import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.response.UserResponse;

import java.util.List;

public interface IUserService {

    UserResponse getUser (Long id);

    UserResponse createUser(CreateUserRequest request) throws Exception;

    List<UserResponse> getAllUsers();

    UserResponse login(LoginRequest loginRequest) throws Exception;


}
