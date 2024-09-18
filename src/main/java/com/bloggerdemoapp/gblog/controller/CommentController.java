package com.bloggerdemoapp.gblog.controller;

import com.bloggerdemoapp.gblog.entity.Comment;
import com.bloggerdemoapp.gblog.entity.Post;
import com.bloggerdemoapp.gblog.repository.CommentRepository;
import com.bloggerdemoapp.gblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    @Autowired
    public CommentController(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    // Create a new comment
    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestParam long postId, @RequestBody Comment comment) {
        Post post = postRepository.findById(postId).get();
        comment.setPost(post); // forigen key
        Comment savedComment = commentRepository.save(comment);
        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }
}