package com.example.demo.DTO.Post.Request;

import com.example.demo.Entity.User;

public record PostCreateRequest(
        String userId,
        String title,
        String content
) { }
