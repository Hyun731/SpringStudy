package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본생성자 설정
    private int post_id;
    @ManyToOne //외래키 알리기
    @JoinColumn(name = "author_id") //애트리뷰트 이름 설정
    private User user;
    private String title;
    private String content;
    private LocalDateTime created_at;

    public static Post create(User user,String title, String content) {
        Post post = new Post();
        post.user = user;
        post.title = title;
        post.content = content;
        post.created_at = LocalDateTime.now();
        return post;
    }

}
