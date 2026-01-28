package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter //롬북이 겟 메서드 자동 작성
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increments
    private Integer id;
    private String userId;
    private String email;
    private String password;
    private LocalDateTime created_at;

    public static User create(String userId,String email, String password) {
        User user = new User();
        user.userId = userId;
        user.email = email;
        user.password = password;
        user.created_at = LocalDateTime.now();
        return user;
    }
}
