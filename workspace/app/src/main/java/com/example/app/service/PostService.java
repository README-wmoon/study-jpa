package com.example.app.service;

import com.example.app.domain.PostDTO;
import com.example.app.entity.Post;
import com.example.app.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {

//    게시글 추가
    public void write(PostDTO postDTO);

//    게시글 목록
    public List<PostDTO> getList();

    public default Post toEntity(PostDTO postDTO){
        return Post.builder().id(postDTO.getId())
                .postTitle(postDTO.getPostTitle())
                .postContent(postDTO.getPostContent())
                .build();
    }
}
















