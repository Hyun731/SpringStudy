package com.example.demo.Repository;

import com.example.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email); //optional을 붙임으로써 메서드를 이용한 검증을 명확하게 하고, null 대처 가능
    Optional<User> findById(String id);
    Optional<User> findByPassword(String password);
}
