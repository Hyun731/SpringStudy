package com.example.demo.DTO.User.Request;

public record UserLoginRequest(
        String userId,
        String password
) {}
