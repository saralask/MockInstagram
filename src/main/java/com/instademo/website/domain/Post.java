package com.instademo.website.domain;

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
    private ImageModel image;

    public Post(String caption, ImageModel image) {
        this.caption = caption;
        this.image = image;
    }
}
