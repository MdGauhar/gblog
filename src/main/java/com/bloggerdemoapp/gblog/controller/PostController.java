package com.bloggerdemoapp.gblog.controller;

import com.bloggerdemoapp.gblog.entity.Post;
import com.bloggerdemoapp.gblog.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post savedPost = postRepository.save(post);
        return new ResponseEntity<>(savedPost, HttpStatus.CREATED);
    }
}
