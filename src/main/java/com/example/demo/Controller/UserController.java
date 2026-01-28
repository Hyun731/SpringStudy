package com.example.demo.Controller;

import com.example.demo.DTO.User.Request.UserCreateRequest;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/post")
    public String CreateUser(@RequestBody UserCreateRequest userCreateRequest){
        return userService.signUp(userCreateRequest);
    }
    @GetMapping("/test")
    public String Test(){
        System.out.println(userService.getClass().getName());
        return userService.Test();
    }
    @GetMapping("/self")
    public String Self(){
        System.out.println(userService.getClass().getName());
        return userService.outMethod();
    }
}
