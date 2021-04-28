package com.instademo.website.service;

import com.instademo.website.Repo.ProfileRepository;
import com.instademo.website.domain.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public List<Profile> getAllProfile() {
        return profileRepository.findAll();
    }
}