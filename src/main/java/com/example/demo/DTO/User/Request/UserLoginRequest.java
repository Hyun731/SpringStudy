package com.example.demo.DTO.User.Request;

public record UserLoginRequest(
        String user_id,
        String password
) {}
