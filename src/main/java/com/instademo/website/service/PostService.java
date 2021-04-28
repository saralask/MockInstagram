package com.instademo.website.service;

import com.instademo.website.Repo.PostRepository;
import com.instademo.website.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Post getThePostById(int id) {
        Optional<Post> postOptional = postRepository.findById(id);
        return postOptional.orElseGet(Post::new);
    }
}