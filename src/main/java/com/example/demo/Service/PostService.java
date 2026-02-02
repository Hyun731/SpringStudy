package com.example.demo.Service;

import com.example.demo.DTO.Post.Request.PostCreateRequest;
import com.example.demo.DTO.Post.Request.PostModifyRequest;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;
import com.example.demo.Repository.PostRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.exception.ResourceNotFound;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository; //@RequiredArgsConstructor 어노테이션을 통해 자동으로 의존성 주입 final,@NonNull 같은 필수 값을 채워줌
    private final UserRepository userRepository;

    @Transactional
    public Post createPost(PostCreateRequest postCreateRequest) {
        User user = userRepository.findByUserId(postCreateRequest.userId()).orElseThrow(()->new ResourceNotFound("ID not Exist"));
        Post newPost = Post.create(
                user,
                postCreateRequest.title(),
                postCreateRequest.content()
        );
        postRepository.save(newPost);
        return newPost;
    }
    @Transactional
    public Post modifyPost(PostModifyRequest postModifyRequest) {
        Post post = postRepository.findPostByPostId(postModifyRequest.postId()).orElseThrow(()->new ResourceNotFound("ID not Exist"));
        post.update(postModifyRequest.title(), postModifyRequest.content());
        return post;
    }
    public List<Post> searchPost(String search) {
        List<Post> posts = postRepository.findByTitleContaining(search);
        return posts;
    }

    @Transactional
    public String deletePost(int postId) {
        postRepository.delete(postRepository.findPostByPostId(postId).orElseThrow(()->new ResourceNotFound("ID not Exist")));
        return "Successfully deleted";
    }
}
