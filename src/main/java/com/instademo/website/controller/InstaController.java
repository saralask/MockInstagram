package com.instademo.website.controller;

import com.instademo.website.domain.Post;
import com.instademo.website.domain.Profile;
import com.instademo.website.service.PostService;
import com.instademo.website.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class InstaController {

    @Autowired
    PostService postService;

    @Autowired
    ProfileService profileService;

    //Uploading profile picture
    @PostMapping("/post")
    public void postImage(@RequestBody MultipartFile file) throws Exception {
        postService.postImage(file);
    }

    //Get All Posts of same Account holder
    @GetMapping("/getThePost/{id}")
    public Post getThePostById(@PathVariable int id) {
        return postService.getThePostById(id);
    }

    //Get list of Profile of all Account Holders
    @GetMapping("/getAllProfile")
    public List<Profile> getAllProfile() {
        return profileService.getAllProfile();
    }

}
