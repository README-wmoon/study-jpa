package com.example.app.domain;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private String postTitle;
    private String postContent;

    @QueryProjection
    public PostDTO(Long id, String postTitle, String postContent) {
        this.id = id;
        this.postTitle = postTitle;
        this.postContent = postContent;
    }
}
