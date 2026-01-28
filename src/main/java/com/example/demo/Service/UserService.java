package com.example.demo.Service;

import com.example.demo.DTO.User.Request.UserCreateRequest;
import com.example.demo.DTO.User.Request.UserLoginRequest;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public String signUp(UserCreateRequest user) {
        if(userRepository.findByEmail(user.email()).isPresent() || userRepository.findByUserId(user.userId()).isPresent()) {
            throw new RuntimeException(); //이미 존재하는 이메일 및 존재하는 아이디
        }
        User newUser = User.create(
                user.userId(),
                user.email(),
                user.password()
        );
        userRepository.save(newUser);
        return "Success";
    }
    public User Login(UserLoginRequest userLoginRequest) {
        User newUser = userRepository.findByUserId(userLoginRequest.userId()).orElseThrow(()->new RuntimeException("User not found"));
        if (!newUser.getPassword().equals(userLoginRequest.password())) {
            throw new RuntimeException("Wrong password");
        }
        return newUser;
    }

    public String outMethod(){
        System.out.println("outMethod");
        return Test();
    }

    @Transactional
    public String Test(){
        User newUser = User.create(
                "TEST",
                "email",
                "password"
        );
        userRepository.save(newUser);

        throw new RuntimeException();
    }
}
