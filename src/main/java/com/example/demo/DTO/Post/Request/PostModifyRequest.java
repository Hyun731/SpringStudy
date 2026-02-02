package com.example.demo.DTO.Post.Request;

public record PostModifyRequest(
        int postId,
        String title,
        String content
) {}
