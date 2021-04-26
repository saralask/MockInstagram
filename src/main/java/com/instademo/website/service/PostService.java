package com.instademo.website.service;

import com.instademo.website.Repo.ImageRepository;
import com.instademo.website.Repo.PostRepository;
import com.instademo.website.domain.Image;
import com.instademo.website.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    ImageRepository imageRepository;


    public void postImage(MultipartFile file) throws IOException {

        Image post = new Image();
        post.setImageFile(file.getBytes());
        imageRepository.save(post);
    }

    public Post getThePostById(int id) {
        Optional<Post> postOptional = postRepository.findById(id);
        return postOptional.orElseGet(Post::new);
    }
}
