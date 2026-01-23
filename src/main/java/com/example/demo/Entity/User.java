package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increments
    private int id;
    private String user_id;
    private String email;
    private String password;
    private LocalDateTime created_at;

    public static User create(String user_id,String email, String password) {
        User user = new User();
        user.user_id = user_id;
        user.email = email;
        user.password = password;
        user.created_at = LocalDateTime.now();
        return user;
    }
}
