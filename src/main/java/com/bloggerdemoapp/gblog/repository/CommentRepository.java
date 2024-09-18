package com.bloggerdemoapp.gblog.repository;

import com.bloggerdemoapp.gblog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}