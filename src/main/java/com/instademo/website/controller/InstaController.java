package com.instademo.website.controller;

import java.io.IOException;

import com.instademo.website.domain.ImageModel;
import com.instademo.website.domain.Post;
import com.instademo.website.domain.Profile;
import com.instademo.website.service.ImageService;
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

    @Autowired
    ImageService imageService;


    /*Get All Posts of same Account holder*/
    @GetMapping("/getThePost/{id}")
    public Post getThePostById(@PathVariable int id) {
        return postService.getThePostById(id);
    }

    /*Get list of Profile of all Account Holders*/
    @GetMapping("/getAllProfile")
    public List<Profile> getAllProfile() {
        return profileService.getAllProfile();
    }

    /*get byte array of image*/
    @GetMapping("/getImageById/{id}")
    public ImageModel getImage(@PathVariable long id) throws IOException {
        return imageService.getImage(id);
    }

    /*upload profile picture <= 300MB*/
    @PostMapping("/upload")
    public void uploadImage(@RequestBody MultipartFile file) throws IOException {
        imageService.uploadImage(file);
    }

}
