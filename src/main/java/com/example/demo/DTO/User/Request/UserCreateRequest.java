package com.example.demo.DTO.User.Request;

//record는 private로 가려주면서 읽을수 있게 메서드를 만들어줌, ex) email을 알고 싶다면 email() 호출
public record UserCreateRequest(
        String user_id,
        String email,
        String password
) {}
