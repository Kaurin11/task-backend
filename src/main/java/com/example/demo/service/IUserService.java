package com.example.demo.service;

import com.example.demo.dto.request.CreateUserRequest;
import com.example.demo.dto.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    UserResponse getUser (UUID id);

    UserResponse createUser(CreateUserRequest request) throws Exception;

    List<UserResponse> getAllUsers();
}
