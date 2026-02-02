package com.example.demo.Controller;

import com.example.demo.DTO.Post.Request.PostCreateRequest;
import com.example.demo.DTO.Post.Request.PostModifyRequest;
import com.example.demo.Entity.Post;
import com.example.demo.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    @PostMapping("/create")
    public Post Hello(@RequestBody PostCreateRequest postCreateRequest){
        return postService.createPost(postCreateRequest);
    }
    @PutMapping("/modify")
    public Post modifyPost(@RequestBody PostModifyRequest postModifyRequest){
        return postService.modifyPost(postModifyRequest);
    }
    @GetMapping("/search")
    public List<Post> searchPost(@RequestParam String search){
        return postService.searchPost(search);
    }
    @DeleteMapping("/delete")
    public String deletePost(@RequestParam int postId){
        return postService.deletePost(postId);
    }
}
