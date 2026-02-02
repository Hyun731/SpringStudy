package com.example.demo.Repository;

import com.example.demo.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    Optional<Post> findPostByPostId(int postId);
    List<Post> findByTitleContaining(String title);
}
