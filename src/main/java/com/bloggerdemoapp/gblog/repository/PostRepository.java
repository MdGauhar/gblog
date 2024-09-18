package com.bloggerdemoapp.gblog.repository;

import com.bloggerdemoapp.gblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}