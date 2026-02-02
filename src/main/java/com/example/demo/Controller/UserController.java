package com.example.demo.Controller;

import com.example.demo.DTO.User.Request.UserCreateRequest;
import com.example.demo.DTO.User.Request.UserLoginRequest;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import com.example.demo.exception.ResourceNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/signup")
    public String CreateUser(@RequestBody UserCreateRequest userCreateRequest){
        return userService.signUp(userCreateRequest);
    }
    @PostMapping("login")
    public User Login(@RequestBody UserLoginRequest userLoginRequest){
        return userService.Login(userLoginRequest);
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
    @GetMapping("/testError")
    public String testError() {
        System.out.println(userService.getClass().getName() );
        throw new ResourceNotFound("테스트 에러");
    }
}