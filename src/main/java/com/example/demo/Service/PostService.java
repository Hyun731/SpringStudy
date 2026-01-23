package com.example.demo.Service;

import com.example.demo.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository; //RequiredArgsConstructor 어노테이션을 통해 자동으로 의존성 주입 final,@NonNull 같은 필수 값을 채워줌
}
