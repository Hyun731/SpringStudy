package com.example.demo.Controller;

import com.example.demo.DTO.User.Request.UserCreateRequest;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/post")
    public String CreateUser(@RequestBody UserCreateRequest userCreateRequest){
        return userService.SignUp(userCreateRequest);
    }
}
