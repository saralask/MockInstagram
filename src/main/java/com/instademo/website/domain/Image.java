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
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int imageId;

    @Lob
    private byte[] imageFile;

    @JsonIgnore
    @OneToOne(mappedBy = "image")
    private Post post;

}
