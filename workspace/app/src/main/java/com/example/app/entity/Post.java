package com.example.app.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_POST")
@Getter @ToString
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull
    private String postTitle;
    @NotNull
    private String postContent;

    @Builder
    public Post(Long id, String postTitle, String postContent) {
        this.id = id;
        this.postTitle = postTitle;
        this.postContent = postContent;
    }
}














