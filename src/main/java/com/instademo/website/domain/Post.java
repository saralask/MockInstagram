package com.instademo.website.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;

    @Column(length = 2000)
    private String caption;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imageId", referencedColumnName = "imageId")
    private Image image;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "person_id", nullable = false)
    private Profile profile;

    public Post(String caption, Profile profile) {
        this.caption = caption;
        this.profile = profile;
    }
}
