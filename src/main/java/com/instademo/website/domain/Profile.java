package com.instademo.website.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int profileId;

    @Column
    private String profileName;

    @Column(length = 2000)
    private String Bio;

    @Column
    private int followers;

    @Column
    private int following;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profile")
    List<Post> posts = new ArrayList<>();

    public Profile(String profileName, String bio, int followers, int following) {
        this.profileName = profileName;
        this.Bio = bio;
        this.followers = followers;
        this.following = following;
    }

}
