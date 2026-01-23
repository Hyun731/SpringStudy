package com.example.demo.Service;

import com.example.demo.DTO.User.Request.UserCreateRequest;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public String SignUp(UserCreateRequest user) {
        if(userRepository.findByEmail(user.email()).isPresent() || userRepository.findById(user.user_id()).isPresent()) {
            throw new RuntimeException(); //이미 존재하는 이메일 및 존재하는 아이디
        }
        User newUser = User.create(
                user.email(),
                user.user_id(),
                user.password()
        );
        userRepository.save(newUser);
        return "Success";
    }
}
